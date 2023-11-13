package com.comp3607project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

public class FlightTest implements TestInterface{
    private Flight flight;
    LocalDateTime creationDate;
    private static int marksAwarded = 0;

    @BeforeEach
    public void testAttributeTypes() {
        creationDate = LocalDateTime.now();
        flight = new Flight("FL123", "New York", "Los Angeles", creationDate);
    }
    
    @Test
    public void testFlightNoAttribute() {
        String flightNo = flight.getFlightNo();

        assertNotNull(flightNo);
        assertTrue(flightNo instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testDestinationAttribute() {
        String destination = flight.getDestination();

        assertNotNull(destination);
        assertTrue(destination instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testOriginAttribute() {
        String origin = flight.getOrigin();

        assertNotNull(origin);
        assertTrue(origin instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testFlightDateAttribute() {
        LocalDateTime flightDate = flight.getFlightDate();

        assertNotNull(flightDate);
        assertTrue(flightDate instanceof LocalDateTime);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testManifestAttribute() {
        LuggageManifest manifest = flight.getManifest();

        assertNotNull(manifest);
        assertTrue(manifest instanceof LuggageManifest);
        marksAwarded = marksAwarded + 1; 
    }

    @Test
    public void testFlightCreation()
    {   
        assertEquals("FL123", flight.getFlightNo());
        assertEquals("New York", flight.getDestination());
        assertEquals("Los Angeles", flight.getOrigin());
        assertEquals(creationDate, flight.getFlightDate());
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testCheckInLuggage() {
        Passenger passenger = new Passenger("HF546645", "Jane", "Doe", "FL123");

        // Test with a valid flight number
        String result = flight.checkInLuggage(passenger);
        double excessCost = flight.getManifest().getExcessLuggageCost(passenger.getNumLuggage(), flight.getAllowedLuggage(passenger.getCabinClass()));
        String expected = "";
        if(passenger.getNumLuggage() == 0)
            expected = "PP NO." + passenger.getPassportNumber()+ " NAME:" + passenger.getFirstName().charAt(0) + "." + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:" + passenger.getCabinClass() + "\n" + "No Luggage to add\n";
        else if(excessCost == 0)
            expected = "PP NO." + passenger.getPassportNumber()+ " NAME:" + passenger.getFirstName().charAt(0) + "." + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:" + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")\n";
        else
            expected = "PP NO." + passenger.getPassportNumber()+ " NAME:" + passenger.getFirstName().charAt(0) + "." + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:" + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")" + " $" + excessCost + "\n";

        assertEquals(expected, result);

        // Test with an invalid flight number
        Passenger invalidPassenger = new Passenger("HF546645", "Jane", "Doe", "HF939");
        result = flight.checkInLuggage(invalidPassenger);
        assertEquals("Invalid flight", result);
        marksAwarded = marksAwarded + 5;
    }

    @Test
    public void testPrintLuggageManifest() {

        // Test printing the luggage manifest
        String manifestString = flight.printLuggageManifest();
        assertNotNull(manifestString);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testGetAllowedLuggage() {
        // Test the getAllowedLuggage method for different cabin classes
        assertEquals(3, flight.getAllowedLuggage('F'));
        assertEquals(2, flight.getAllowedLuggage('B'));
        assertEquals(1, flight.getAllowedLuggage('P'));
        assertEquals(0, flight.getAllowedLuggage('E'));
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testToString() {
        Flight flight = new Flight("FL123", "New York", "Los Angeles", LocalDateTime.now());

        // Test the toString method
        String flightString = flight.toString();
        assertNotNull(flightString);
        marksAwarded = marksAwarded + 1;
    }

    @Override
    public int getMarks()
    {
        return marksAwarded;
    }
}
