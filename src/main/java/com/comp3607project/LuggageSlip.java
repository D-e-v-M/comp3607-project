package com.comp3607project;

//816030364
public class LuggageSlip {
    private Passenger owner;
    private int luggageSlipIDCounter;
    private String luggageSlipID;
    private String label;

    public LuggageSlip(Passenger p, Flight f) {
        this.owner = p;
        this.luggageSlipIDCounter = 0;
        this.luggageSlipID = f.getFlightNo() + "_" + owner.getLastName();
        this.label = "";
    }

    public LuggageSlip(Passenger p, Flight f, String label) {
        this.owner = p;
        this.luggageSlipIDCounter = 0;
        this.luggageSlipID = f.getFlightNo() + "_" + owner.getLastName();
        this.label = label;
    }

    public boolean hasOwner(String passportNumber) {
        if (this.owner.getPassportNumber().equals(passportNumber)) {
            return true;
        }

        return false;
    }

    public Passenger getOwner() {
        return owner;
    }

    public int getLuggageSlipIDCounter() {
        luggageSlipIDCounter++;
        return luggageSlipIDCounter;
    }

    public String getLuggageSlipID() {
        return luggageSlipID;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        String passengerDetails = "";

        for (int i = 1; i <= owner.getNumLuggage(); i++) {
            passengerDetails += "\n" + getLuggageSlipID() + "_" + getLuggageSlipIDCounter()
                    + " PP NO. " + owner.getPassportNumber() + " NAME: "
                    + owner.getFirstNameLetter() + "." + owner.getLastName() + " NUMLUGGAGE: " +
                    owner.getNumLuggage() + " CLASS: " + owner.getCabinClass() + " " + getLabel();

        }
        return passengerDetails;
    }
}