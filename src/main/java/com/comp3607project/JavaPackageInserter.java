package com.comp3607project;

import java.io.*;

public class JavaPackageInserter {

    public static void addPackageDeclaration(File javaFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(javaFile));
             RandomAccessFile randomAccessFile = new RandomAccessFile(javaFile, "rw")) {
    
            StringBuilder fileContent = new StringBuilder(); 
    
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("package ")) {
                    fileContent.append(line).append(System.lineSeparator());
                }
            }
    
            
            fileContent.insert(0, "package com.comp3607project.tests;" + System.lineSeparator());
    
            
            randomAccessFile.setLength(0);
    
            
            randomAccessFile.writeBytes(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
