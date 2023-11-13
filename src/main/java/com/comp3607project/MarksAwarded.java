package com.comp3607project;

public class MarksAwarded {

    PassengerTest passenger;
    FlightTest flight;
    LuggageSlipTest luggageSlip;
    LuggageManifestTest luggageManifest;
    int totalMarks;
    
    public MarksAwarded(){
        passenger = new PassengerTest();
        flight = new FlightTest();
        luggageSlip = new LuggageSlipTest();
        luggageManifest = new LuggageManifestTest();

    }

    public int calculateTotalMarks() {
        totalMarks = getPassengerTestMarks() + getFlightTestMarks() + getLuggageSlipTestMarks() + getLuggageManifestTestMarks();
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
