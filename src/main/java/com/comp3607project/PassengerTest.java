package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        // Create a Passenger instance before each test
        passenger = new Passenger("TA890789", "Joe", "Bean", "FL123");
        passenger.assignRandomCabinClass();
        passenger.assignRandomNumLuggage();
    }

    @Test
    void testPassportNumber() {
        // Test the passportNumber attribute type
        assertNotNull(passenger.getPassportNumber());
        assertTrue(passenger.getPassportNumber() instanceof String);
    }

    @Test
    void testFlightNo() {
        // Test the flightNo attribute type
        assertNotNull(passenger.getFlightNo());
        assertTrue(passenger.getFlightNo() instanceof String);
    }

    @Test
    void testFirstName() {
        // Test the firstName attribute type
        assertNotNull(passenger.getFirstName());
        assertTrue(passenger.getFirstName() instanceof String);
    }

    @Test
    void testLastName() {
        // Test the lastName attribute type
        assertNotNull(passenger.getLastName());
        assertTrue(passenger.getLastName() instanceof String);
    }

    @Test
    void testNumLuggage() {
        // Test the numLuggage attribute type
        assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() <= 5);
    }

    @Test
    void testCabinClass() {
        // Test the cabinClass attribute type
        assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
                   passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
    }

    @Test
    void testAssignRandomCabinClass() {
        // Test the assignRandomCabinClass method
        passenger.assignRandomCabinClass();
        assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
                   passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
    }

    @Test
    void testToString() {
        // Test the toString method
        String expectedString = " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + passenger.getNumLuggage() + " CLASS: " + passenger.getCabinClass();
        assertEquals(expectedString, passenger.toString());
    }
}
