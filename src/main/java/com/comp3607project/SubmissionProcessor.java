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
    
    public void processSubmissions(List<File> submissions) throws IOException{
        ZipFile studentSubmission = null;
        File destAddr = new File("/main");

        for (File file : submissions) {
            try {
                studentSubmission = new ZipFile(file);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Enumeration<? extends ZipEntry> zipEntries = studentSubmission.entries();
            
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                File newFile = new File(destAddr, zipEntry.getName());
                // create sub directories
                newFile.getParentFile().mkdirs();

                if (!zipEntry.isDirectory() && zipEntry.getName().endsWith(".java")) {
                    // write all .java files to javaFiles folder
                    try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
                        BufferedInputStream inputStream = new BufferedInputStream(studentSubmission.getInputStream(zipEntry));
                        while (inputStream.available() > 0) {
                            outputStream.write(inputStream.read());
                        }
                        inputStream.close();
                        
                        // run tests
                    }
                }
            }
            // delete all files in resources folder, go to next student submission
        }
    }
}
