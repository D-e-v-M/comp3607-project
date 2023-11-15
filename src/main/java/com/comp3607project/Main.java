package com.comp3607project;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args) {

        // ProjectManager projectManager = new ProjectManager();

        // Specify the path to the zipped file
        String filePath = "Initial.zip";

        // Process student submissions
        // projectManager.processStudentSubmissions(filePath);

        // Runs test cases on startup
        Result result = JUnitCore.runClasses(TestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }
}
