package com.comp3607project;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({PassengerTest.class, FlightTest.class, LuggageSlipTest.class, LuggageManifestTest.class})

public class TestSuite {
    // This class doesn't need any test methods.
}