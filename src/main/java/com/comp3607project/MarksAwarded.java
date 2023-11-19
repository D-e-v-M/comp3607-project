package com.comp3607project;

import com.comp3607project.tests.FlightTest;
import com.comp3607project.tests.LuggageManifestTest;
import com.comp3607project.tests.LuggageSlipTest;
import com.comp3607project.tests.PassengerTest;

public class MarksAwarded {

    TestInterface passenger;
    TestInterface flight;
    TestInterface luggageSlip;
    TestInterface luggageManifest;
    int totalMarks = 0;

    public MarksAwarded() {
        passenger = new PassengerTest();
        flight = new FlightTest();
        luggageSlip = new LuggageSlipTest();
        luggageManifest = new LuggageManifestTest();

    }

    public int calculateTotalMarks() {
        totalMarks = getPassengerTestMarks() + getFlightTestMarks() + getLuggageSlipTestMarks()
                + getLuggageManifestTestMarks();
        return totalMarks;
    }

    public int getPassengerTestMarks() {
        return passenger.getMarks();
    }

    public int getFlightTestMarks() {
        return flight.getMarks();
    }

    public int getLuggageSlipTestMarks() {
        return luggageSlip.getMarks();
    }

    public int getLuggageManifestTestMarks() {
        return luggageManifest.getMarks();
    }

    public int getTotalMarks() {
        return this.totalMarks;
    }
}
