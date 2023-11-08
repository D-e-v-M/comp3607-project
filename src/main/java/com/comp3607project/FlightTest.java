package com.comp3607project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

public class FlightTest {
    private Flight flight;

    @BeforeEach
    public void testAttributeTypes() {
        flight = new Flight("FL123", "New York", "Los Angeles", LocalDateTime.now());
    }
    @Test
    public void testFlightNoAttribute() {
        String flightNo = flight.getFlightNo();

        assertNotNull(flightNo);
        assertTrue(flightNo instanceof String);
        assertEquals("FL123", flightNo);
    }

    @Test
    public void testDestinationAttribute() {
        String destination = flight.getDestination();

        assertNotNull(destination);
        assertTrue(destination instanceof String);
        assertEquals("New York", destination);
    }

    @Test
    public void testOriginAttribute() {
        String origin = flight.getOrigin();

        assertNotNull(origin);
        assertTrue(origin instanceof String);
        assertEquals("Los Angeles", origin);
    }

    @Test
    public void testFlightDateAttribute() {
        LocalDateTime flightDate = flight.getFlightDate();

        assertNotNull(flightDate);
        assertTrue(flightDate instanceof LocalDateTime);
    }

    @Test
    public void testManifestAttribute() {
        LuggageManifest manifest = flight.getManifest();

        assertNotNull(manifest);
        assertTrue(manifest instanceof LuggageManifest);
        
    }

    @Test
    public void testCheckInLuggage() {
        Passenger passenger = new Passenger("HF546645", "Jane", "Doe", "FL123");

        // Test with a valid flight number
        String result = flight.checkInLuggage(passenger);
        double excessCost = flight.getManifest().getExcessLuggageCost(passenger.getNumLuggage(), Flight.getAllowedLuggage(passenger.getCabinClass()));
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
    }

    @Test
    public void testPrintLuggageManifest() {

        // Test printing the luggage manifest
        String manifestString = flight.printLuggageManifest();
        assertNotNull(manifestString);
        // Add assertions based on the expected format of the manifest string
    }

    @Test
    public void testGetAllowedLuggage() {
        // Test the getAllowedLuggage method for different cabin classes
        assertEquals(3, Flight.getAllowedLuggage('F'));
        assertEquals(2, Flight.getAllowedLuggage('B'));
        assertEquals(1, Flight.getAllowedLuggage('P'));
        assertEquals(0, Flight.getAllowedLuggage('E'));
    }

    @Test
    public void testToString() {
        Flight flight = new Flight("FL123", "New York", "Los Angeles", LocalDateTime.now());

        // Test the toString method
        String flightString = flight.toString();
        assertNotNull(flightString);
        // Add assertions based on the expected format of the flight string
    }
}
