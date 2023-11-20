package com.comp3607project;

public class MarksAwarded {

    TestInterface passenger;
    TestInterface flight;
    TestInterface luggageSlip;
    TestInterface luggageManifest;
    String totalScoreOverall = "\n";
    int totalMarks = 0;

    public MarksAwarded() {
        passenger = new PassengerTest();
        flight = new FlightTest();
        luggageSlip = new LuggageSlipTest();
        luggageManifest = new LuggageManifestTest();

    }

    public String TotalStudentScore() {
        totalMarks = getPassengerTestMarks() + getFlightTestMarks() + getLuggageSlipTestMarks()
                + getLuggageManifestTestMarks();
        totalScoreOverall += getPassengerTestOutput() + getFlightTestOutput() + getLuggageSlipTestOutput()
                + getLuggageManifestTestOutput();
        
        totalScoreOverall += "\n Overall Score for Submission: " + totalMarks + "/66 \n";
        
        return totalScoreOverall;
    }

    public int getPassengerTestMarks() {
        return passenger.getMarks();
    }

    public String getPassengerTestOutput() {
        return passenger.getOverallOutput();
    }

    public int getFlightTestMarks() {
        return flight.getMarks();
    }

    public String getFlightTestOutput() {
        return flight.getOverallOutput();
    }

    public int getLuggageSlipTestMarks() {
        return luggageSlip.getMarks();
    }

    public String getLuggageSlipTestOutput() {
        return luggageSlip.getOverallOutput();
    }

    public int getLuggageManifestTestMarks() {
        return luggageManifest.getMarks();
    }

    public String getLuggageManifestTestOutput() {
        return luggageManifest.getOverallOutput();
    }
}
