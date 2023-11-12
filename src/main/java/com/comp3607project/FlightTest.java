package com.comp3607project;

import org.junit.jupiter.api.BeforeAll;
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
        assertEquals("Luggage added to the flight", result);

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