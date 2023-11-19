package com.comp3607project.fileProcessing;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.comp3607project.JavaPackageInserter;
import com.comp3607project.TestSuite;
import com.itextpdf.text.DocumentException;

public class SubmissionProcessor {
    // This class unzips the student's submission folder and saves their code for
    // testing
    public SubmissionProcessor() {
    }

    public void processSubmissions(List<File> submissions) throws IOException, DocumentException {
        File destAddr = new File("src\\main\\java\\com\\comp3607project");
        List<File> files = new ArrayList<>();

        for (File file : submissions) {
            try (ZipFile studentSubmission = new ZipFile(file)) {
                Enumeration<? extends ZipEntry> zipEntries = studentSubmission.entries();

                while (zipEntries.hasMoreElements()) {
                    ZipEntry zipEntry = zipEntries.nextElement();
                    File newFile = new File(destAddr, zipEntry.getName());

                    // create sub directories
                    newFile.getParentFile().mkdirs();

                    if (!zipEntry.isDirectory() && zipEntry.getName().endsWith(".java")) {

                        files.add(new File(destAddr, zipEntry.getName()));

                        // write all .java files to studentFiles folder
                        try (FileOutputStream outputStream = new FileOutputStream(newFile);
                                BufferedInputStream inputStream = new BufferedInputStream(
                                        studentSubmission.getInputStream(zipEntry))) {
                            while (inputStream.available() > 0) {
                                outputStream.write(inputStream.read());
                            }
                        }
                        // add package headings
                        JavaPackageInserter.addPackageDeclaration(newFile);
                    }
                }

                // get name of current student zip file
                String filename = studentSubmission.getName();
                filename = filename.substring(46);
                filename = filename.replaceAll(".zip", "");

                // run test on studentFiles, reference paths
                TestSuite suite = new TestSuite();
                suite.runTests(filename);

                // delete studentFiles
                FileDeleter.deleteFiles(files);
            } catch (IOException e) {
                System.out.println("[SubmissionProcessor]: Error processing submissions.");
            }
        }
    }
}
