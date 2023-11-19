package com.comp3607project;

import com.itextpdf.text.DocumentException;

public class Main {

    public static void main(String[] args) throws DocumentException {

        ProjectManager projectManager = new ProjectManager();

        // Specify the path to the zipped file
        String filePath = "data\\Submissions.zip";

        // Process student submissions
        projectManager.processStudentSubmissions(filePath);

        // Runs test cases on startup
        // Result result = JUnitCore.runClasses(TestSuite.class);

        // for (Failure failure : result.getFailures()) {
        // System.out.println(failure.toString());
        // }

        // System.out.println(result.wasSuccessful());

    }
}
