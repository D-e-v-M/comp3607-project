package com.comp3607project;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.itextpdf.text.DocumentException;

public class SubmissionProcessor2 {
    // This class unzips the student's submission folder and saves their code for testing
    public SubmissionProcessor2() {
    }

    public void processSubmissions(List<File> submissions) throws IOException, DocumentException {
        File destAddr = new File("src\\main\\java\\com\\comp3607project");
        File classFilesDestAddr = new File("target\\test-classes"); // Adjust the destination for class files
        List<File> files = new ArrayList<>();

        for (File file : submissions) {
            System.out.println("[SubmissionProcessor2]: "+ file.getAbsolutePath());

            try (ZipFile studentSubmission = new ZipFile(file)) {
                Enumeration<? extends ZipEntry> zipEntries = studentSubmission.entries();

                while (zipEntries.hasMoreElements()) {
                    ZipEntry zipEntry = zipEntries.nextElement();
                    File newFile = new File(destAddr, zipEntry.getName());

                    // create sub directories
                    newFile.getParentFile().mkdirs();

                    if (!zipEntry.isDirectory() && zipEntry.getName().endsWith(".java")) {

                        files.add(newFile);

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

                // Compile Java files to generate class files
                System.out.println("[SubmissionProcessor]: Recompiling files.");

                compileJavaFiles(files, classFilesDestAddr);

                // get name of current student zip file
                String filename = studentSubmission.getName();
                filename = filename.substring(46);
                filename = filename.replaceAll(".zip", "");

                // run test on class files
                TestSuite suite = new TestSuite();
                suite.runTests(filename);

                // delete studentFiles
                FileDeleter.deleteFiles(files);
            } catch (IOException e) {
                System.out.println("[SubmissionProcessor]: Error processing submissions.");
            }
        }
    }

    private void compileJavaFiles(List<File> javaFiles, File destAddr) throws IOException {
        // Compile Java files to generate class files
        String[] command = new String[javaFiles.size() + 3];
        command[0] = "javac";
        command[1] = "-d";
        command[2] = destAddr.getAbsolutePath();

        for (int i = 0; i < javaFiles.size(); i++) {
            command[i + 3] = javaFiles.get(i).getAbsolutePath();
        }

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

