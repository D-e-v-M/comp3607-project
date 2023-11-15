package com.comp3607project;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    

    public void runAssignmentTests(Class<?> testSuiteClass) {
        Result result = JUnitCore.runClasses(testSuiteClass);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
