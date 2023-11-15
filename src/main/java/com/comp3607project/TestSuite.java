package com.comp3607project;

import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PassengerTest.class, FlightTest.class, LuggageSlipTest.class, LuggageManifestTest.class })

public class TestSuite {
    // This class doesn't need any test methods.
}