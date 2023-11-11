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


public class Extractor {

    public Extractor() {
    }
    
    public List<File> extractSecondaryZips(String primaryZipPath, String destinationDirectory) throws IOException {
        List<File> extractedZipFiles = new ArrayList<>();

        try (ZipFile primaryZipFile = new ZipFile(primaryZipPath)) {
            Enumeration<? extends ZipEntry> zipEntries = primaryZipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                File newFile = new File(destinationDirectory, zipEntry.getName());

                if (!zipEntry.isDirectory()) {
                    newFile.getParentFile().mkdirs();

                    try (FileOutputStream outputStream = new FileOutputStream(newFile);
                         BufferedInputStream inputStream = new BufferedInputStream(primaryZipFile.getInputStream(zipEntry))) {
                        while (inputStream.available() > 0) {
                            outputStream.write(inputStream.read());
                        }
                    }

                    extractedZipFiles.add(newFile);
                }
            }
        }

        return extractedZipFiles;
    }
}
