package com.comp3607project;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProjectManager {
    
    private Extractor extractor;
    private SubmissionProcessor processor;

    public ProjectManager(){
        this.extractor = new Extractor();
        this.processor = new SubmissionProcessor();
    }

    public void processStudentSubmissions(String filePath){
        String destPath = "/resources";
        try {
            List<File> secondaryZips = extractor.extractSecondaryZips(filePath, destPath);
            this.processor.processSubmissions(secondaryZips);
        } catch (IOException e) {
            System.out.println("[ProjectManager] : Error extracting files,");
        }

    }

}
