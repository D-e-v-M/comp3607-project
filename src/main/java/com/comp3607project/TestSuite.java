package com.comp3607project;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.itextpdf.text.DocumentException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PassengerTest.class, FlightTest.class, LuggageSlipTest.class, LuggageManifestTest.class })

public class TestSuite {
    // This class doesn't need any test methods.

    public void runTests() throws FileNotFoundException, DocumentException {
        // Runs test cases on startup

        Result result = JUnitCore.runClasses(TestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

        DocumentBuilder generator = new PDFGenerator();
        ArrayList<TestCase> testCases = FlightTest.getTestCasesList();
        testCases.addAll(LuggageManifestTest.getTestCasesList());
        testCases.addAll(LuggageSlipTest.getTestCasesList());
        testCases.addAll(PassengerTest.getTestCasesList());
        generator.addTestCases(testCases);
        generator.createDocument();

        for (TestCase t : testCases) {
            System.out.println(t.getName());
        }

    }
}