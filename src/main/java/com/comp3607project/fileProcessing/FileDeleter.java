package com.comp3607project.fileProcessing;

import java.io.File;
import java.util.List;

public class FileDeleter {

    public static void deleteFiles(List<File> files){
        for (File f : files) {
            try {
                f.delete();
            } catch (Exception e) {
                System.out.println("[FileDeleter]: Could not delete " + f.getName());
            }
        }
    }
}
