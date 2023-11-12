package com.comp3607project;


public class Main {

    public static void main(String[] args) {

        ProjectManager projectManager = new ProjectManager();

        // Specify the path to the zipped file
        String filePath = "Initial.zip";

        // Process student submissions
        projectManager.processStudentSubmissions(filePath);
    }
}
