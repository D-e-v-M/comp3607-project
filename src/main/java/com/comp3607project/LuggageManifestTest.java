package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuggageManifestTest {
    private LuggageManifest luggageManifest;
    private Flight flight;
    private Passenger passenger;
    ArrayList<LuggageSlip> slips;

    @BeforeEach
    public void setUp() {
        slips = new ArrayList<LuggageSlip>();
        luggageManifest = new LuggageManifest();
        flight = new Flight("BW600", "Destination", "Origin", LocalDateTime.now());
        passenger = new Passenger("TA890789", "John", "Bean", "BW600");
        passenger.assignRandomCabinClass();
        passenger.assignRandomNumLuggage();
    }

    @Test
    void testSlipsAttributeType() {
        slips = luggageManifest.getSlips();
        assertNotNull(slips);
        assertTrue(slips instanceof ArrayList);
    }

    @Test
    void testLuggageManifestConstructor() {
        slips = luggageManifest.getSlips();
        assertNotNull(slips);
        assertEquals(0, slips.size());
    }

    @Test
    public void testAddLuggage() {
        // Test the addLuggage method
        String expectedOutput = "";
        int numLuggage = passenger.getNumLuggage();
        int allowedLuggage = Flight.getAllowedLuggage(passenger.getCabinClass());
        double excessPiecesCost = luggageManifest.getExcessLuggageCost(passenger.getNumLuggage(), allowedLuggage);
        
        expectedOutput = "PP NO. " + passenger.getPassportNumber() + " NAME: "
        + passenger.getFirstNameLetter() + "." + passenger.getLastName() + " NUMLUGGAGE: " +
        passenger.getNumLuggage() + " CLASS: " + passenger.getCabinClass() + "\n";
            
        if ((numLuggage == 0) || (numLuggage <= allowedLuggage))
        {
            slips.add(new LuggageSlip(passenger, flight));
            
            if (numLuggage == 0)
            {
                expectedOutput+= "No Luggage to add. \n";
            }
            
            if (numLuggage <= allowedLuggage)
            {
                expectedOutput+= "Pieces Added: (" + numLuggage + "). Excess Cost: $0 \n";
            }
        }
        
        if (numLuggage > allowedLuggage)
        {
                String label = "$" + excessPiecesCost;
                slips.add(new LuggageSlip(passenger, flight, label));
                
                expectedOutput+= "Pieces Added: (" + numLuggage + "). Excess Cost: $" + excessPiecesCost + "\n";
        }
        String output = luggageManifest.addLuggage(passenger, flight);
        assertEquals(expectedOutput, output);
        // Check if the slips collection contains the expected number of slips
        assertEquals(1, luggageManifest.getSlips().size());
    }

    /* 
    @Test
    public void testGetExcessLuggageCost() {
        // Test the getExcessLuggageCost method
        int numLuggage = passenger.getNumLuggage();
        int allowedLuggage = Flight.getAllowedLuggage(passenger.getCabinClass());
        double excessPiecesCost;
        
        if (numLuggage <= allowedLuggage)
        {
            excessPiecesCost = 0;
        }
        
        else
        {
            int excessPieces = numLuggage - allowedLuggage;
            excessPiecesCost = excessPieces * 35;
        }
        double cost = luggageManifest.getExcessLuggageCost(numLuggage, allowedLuggage);
        assertEquals(excessPiecesCost, cost);
    }*/

    @Test
    public void testGetExcessLuggageCostByPassenger() {
        // Test the getExcessLuggageCostByPassenger method
        luggageManifest.addLuggage(passenger, flight);
        String costOutput = luggageManifest.getExcessLuggageCostByPassenger("TA890789");
        assertEquals("$35", costOutput);

        String noCostOutput = luggageManifest.getExcessLuggageCostByPassenger("NonExistentPassportNumber");
        assertEquals("No Cost", noCostOutput);
    }

    @Test
    public void testToString() {
        // Test the toString method
        luggageManifest.addLuggage(passenger, flight);
        String manifestString = luggageManifest.toString();
        // Create an expected manifest string based on the provided sample output
        String expectedManifestString = "LUGGAGE MANIFEST: \n" +
            "BW600_Bean_1 PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 2 CLASS: P $35\n";
        assertEquals(expectedManifestString, manifestString);
    }
}