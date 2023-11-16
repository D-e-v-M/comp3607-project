package com.comp3607project;

import java.io.*;

public class JavaPackageInserter {

    public static void addPackageDeclaration(File javaFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(javaFile));
             RandomAccessFile randomAccessFile = new RandomAccessFile(javaFile, "rw")) {
    
            StringBuilder fileContent = new StringBuilder(); // Store the entire file content
    
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("package ")) {
                    fileContent.append(line).append(System.lineSeparator());
                }
            }
    
            // Prepend the desired package declaration to the file content
            fileContent.insert(0, "package com.comp3607project;" + System.lineSeparator());
    
            // Truncate the file content to the beginning
            randomAccessFile.setLength(0);
    
            // Write the modified file content to the file
            randomAccessFile.writeBytes(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
