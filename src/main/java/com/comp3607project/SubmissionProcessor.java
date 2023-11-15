package com.comp3607project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.junit.runner.JUnitCore;

public class SubmissionProcessor {
    // This class unzips the student's submission folder and saves their code for
    // testing
    public SubmissionProcessor() {
    }

    public void processSubmissions(List<File> submissions) throws IOException {
        File destAddr = new File("comp3607-project\\src\\main\\java\\com\\comp3607project");
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
                    }
                }
                // run test on studentFiles, reference paths
                //JUnitCore.runClasses(TestSuite.class); //run the test cases, don't need output 
                
                // delete studentFiles
                FileDeleter.deleteFiles(files);
            } catch (IOException e) {
                System.out.println("[SubmissionProcessor]: Error processing submissions.");
            }
        }
    }
}
