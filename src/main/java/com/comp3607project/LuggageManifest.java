package com.comp3607project;

//816030364
import java.util.ArrayList;

public class LuggageManifest {
    private ArrayList<LuggageSlip> slips;

    public LuggageManifest() {
        slips = new ArrayList<LuggageSlip>();
    }

    public ArrayList<LuggageSlip> getSlips() {
        return slips;
    }

    public String addLuggage(Passenger p, Flight f) {
        String luggageOutput = "";
        int numLuggage = p.getNumLuggage();
        int allowedLuggage = f.getAllowedLuggage(p.getCabinClass());
        double excessPiecesCost = getExcessLuggageCost(p.getNumLuggage(), allowedLuggage);

        luggageOutput = "PP NO. " + p.getPassportNumber() + " NAME: "
                + p.getFirstNameLetter() + "." + p.getLastName() + " NUMLUGGAGE: " +
                p.getNumLuggage() + " CLASS: " + p.getCabinClass() + "\n";

        if ((numLuggage == 0) || (numLuggage <= allowedLuggage)) {
            slips.add(new LuggageSlip(p, f));

            if (numLuggage == 0) {
                luggageOutput += "No Luggage to add. \n";
            }

            if (numLuggage <= allowedLuggage) {
                luggageOutput += "Pieces Added: (" + numLuggage + "). Excess Cost: $0 \n";
            }
        }

        if (numLuggage > allowedLuggage) {
            String label = "$" + excessPiecesCost;
            slips.add(new LuggageSlip(p, f, label));

            luggageOutput += "Pieces Added: (" + numLuggage + "). Excess Cost: $" + excessPiecesCost + "\n";
        }

        return luggageOutput;
    }

    public double getExcessLuggageCost(int numPieces, int numAllowedPieces) {
        double excessPiecesCost;

        if (numPieces <= numAllowedPieces) {
            excessPiecesCost = 0;
        }

        else {
            int excessPieces = numPieces - numAllowedPieces;
            excessPiecesCost = excessPieces * 35;
        }

        return excessPiecesCost;
    }

    public String getExcessLuggageCostByPassenger(String passportNumber) {
        String luggageCostLabel = "";
        String excessCostOutput = "";
        boolean passportNumberFound = false;

        for (LuggageSlip slip : slips) {
            if (slip.hasOwner(passportNumber) == true) {
                passportNumberFound = true;
                luggageCostLabel = slip.getLabel();

                if (luggageCostLabel.equals("") && (slip.getOwner().getNumLuggage() != 0)) {
                    excessCostOutput = "No Cost ";
                }
            }

        }

        if (passportNumberFound != true) {
            excessCostOutput = "Passport Number NOT Found!";
        }

        return excessCostOutput;
    }

    public String toString() {
        String luggageManifestOutput = "LUGGAGE MANIFEST: \n";

        for (LuggageSlip slip : slips) {
            luggageManifestOutput += slip.toString() + " " +
                    getExcessLuggageCostByPassenger(slip.getOwner().getPassportNumber()) + "\n";
        }

        return luggageManifestOutput;
    }

}