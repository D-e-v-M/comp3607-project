package com.comp3607project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SubmissionProcessor {
    // This class unzips the student's submission folder and saves their code for testing
    public SubmissionProcessor() {
    }
    
    public void processSubmissions(List<File> submissions) throws IOException {
        File destAddr = new File("testing");

        for (File file : submissions) {
            try (ZipFile studentSubmission = new ZipFile(file)) {
                Enumeration<? extends ZipEntry> zipEntries = studentSubmission.entries();

                while (zipEntries.hasMoreElements()) {
                    ZipEntry zipEntry = zipEntries.nextElement();
                    File newFile = new File(destAddr, zipEntry.getName());
                    
                    // create sub directories
                    newFile.getParentFile().mkdirs();

                    if (!zipEntry.isDirectory() && zipEntry.getName().endsWith(".java")) {
                        // write all .java files to studentFiles folder
                        try (FileOutputStream outputStream = new FileOutputStream(newFile);
                             BufferedInputStream inputStream = new BufferedInputStream(studentSubmission.getInputStream(zipEntry))) {
                            while (inputStream.available() > 0) {
                                outputStream.write(inputStream.read());
                            }
                        }
                    }

                    //run test on studentFiles, reference paths
                    //delete studentFiles
                }
            } catch (IOException e) {
                // handle exception, e.g., log or print an error message
                e.printStackTrace();
            }
        }
    }
}
