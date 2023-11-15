package com.comp3607project;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuggageManifestTest implements TestInterface{
    private Passenger p;
    private Flight f;
    private static int marksAwarded = 0;

    @BeforeEach
    public void initAddLuggage(){
        LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 0, 0);
        f = new Flight("BW600", "POS", "ANR",d);
        p = new Passenger("TA890789", "Joe", "Bean", "BW600");
    }

    @Test
    public void testLuggageSlipIDAttribute(){
        LuggageManifest LM = f.getManifest();
        assertTrue(LM.getSlips() instanceof ArrayList);
        marksAwarded = marksAwarded + 2; 
    }

    @Test 
    public void testLuggageManifestCreation(){
        LuggageManifest LM = f.getManifest();
        assertNotNull(LM.getSlips());
        marksAwarded = marksAwarded + 1; 
    }

    @Test
    public void testAddLuggage(){
        String actual =(f.getManifest()).addLuggage(p,f);
        String expected = "";
        double excessCost = f.getManifest().getExcessLuggageCost(p.getNumLuggage(), f.getAllowedLuggage(p.getCabinClass()));
        if(p.getNumLuggage() == 0)
            expected = "PP NO. " + p.getPassportNumber()+ " NAME: " + p.getFirstName().charAt(0) + "." + p.getLastName().toUpperCase() + " NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass() + "\n" + "No Luggage to add.\n";
        else if(p.getNumLuggage() > 0 && excessCost == 0)
            expected = "PP NO. " + p.getPassportNumber()+ " NAME: " + p.getFirstName().charAt(0) + "." + p.getLastName().toUpperCase() + " NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass() + "\n" + "Pieces Added: " + "(" + p.getNumLuggage() + "). Excess Cost: $0\n";
        else
            expected = "PP NO. " + p.getPassportNumber()+ " NAME: " + p.getFirstName().charAt(0) + "." + p.getLastName().toUpperCase() + " NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass() + "\n" + "Pieces Added: " + "(" + p.getNumLuggage() + ")." + " Excess Cost: $" + excessCost + "\n";
        
        assertEquals(expected, actual);
        marksAwarded = marksAwarded + 6; 
    }

    @Test
    public void testGetExcessLuggageCost(){
        double expected =(f.getManifest()).getExcessLuggageCost(p.getNumLuggage(), f.getAllowedLuggage(p.getCabinClass()));
        double actual = 0;
        char cabinClass = p.getCabinClass();
        int numAllowedPieces = f.getAllowedLuggage(cabinClass);
        int numPieces = p.getNumLuggage();

        if(p.getCabinClass() == 'E'){
            numAllowedPieces = 0;
            if(numPieces > numAllowedPieces){
                actual = (numPieces - numAllowedPieces) * 35;
            } 
        }
        else if (p.getCabinClass() == 'P'){
            numAllowedPieces = 1;
            if(numPieces > numAllowedPieces){
                actual = (numPieces - numAllowedPieces) * 35;
            } 
        }
        else if(p.getCabinClass() == 'B'){
            numAllowedPieces = 2;
            if(numPieces > numAllowedPieces){
                actual = (numPieces - numAllowedPieces) * 35;
            } 
        }
        else if (p.getCabinClass() == 'F'){
            numAllowedPieces = 3;
            if(numPieces > numAllowedPieces){
                actual = (numPieces - numAllowedPieces) * 35;
            }   
        }

        assertEquals(expected,actual, 0.01);
        marksAwarded = marksAwarded + 3; 
    }
  
    @Test
    public void testGetExcessLuggageCostByPassenger(){
        String actual =(f.getManifest()).getExcessLuggageCostByPassenger(p.getPassportNumber());
        
        int allowedLuggage = f.getAllowedLuggage(p.getCabinClass());
        int numLuggage = p.getNumLuggage();
        double excessCost;
        if (numLuggage == 0 || numLuggage <= allowedLuggage)
            excessCost = 0;
        else
            excessCost = 35.0 * (numLuggage - allowedLuggage);
        
        String expected;
        if(excessCost == 0)
        {
            expected = "No Cost";
        }
        else
        {
            expected = "$" + excessCost;
        }
        
        assertEquals(expected, actual);
        marksAwarded = marksAwarded + 5;
    }

    @Test
    public void testToString(){
        String actual = f.getManifest().toString();
        double excessCost = f.getManifest().getExcessLuggageCost(p.getNumLuggage(), f.getAllowedLuggage(p.getCabinClass()));
        String label;
        if(excessCost == 0){
            label = "";
        }
        else{
            label = "$" + excessCost;
        }
        
        String expected = "LUGGAGE MANIFEST: \n";
        String slipOutput = "";
        for(int i=1; i<=p.getNumLuggage(); i++)
        {
            slipOutput += "BW600_Bean_" + i + " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass() + " " + label + "\n";
        }        
        expected = expected + slipOutput;
        assertEquals(expected, actual);
        marksAwarded = marksAwarded + 3;
    }

    @Override
    public int getMarks()
    {
        return marksAwarded;
    }

}
