package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    String passportNumber = "TA890789";
    String firstName = "Joe";
    String lastName = "Bean";
    String flightNo = "BW600";

    private Passenger passenger;
    private static int marksAwarded = 0;
    
    @BeforeEach
    public void setUp() {
        // Create a Passenger instance before each test
        passenger = new Passenger("TA890789", "Joe", "Bean", "BW600");
        passenger.assignRandomCabinClass();
        passenger.assignRandomNumLuggage();
    }

    @Test
    public void testPassportNumberAttribute(){
        // Test the passportNumber attribute type
        assertNotNull(passenger.getPassportNumber());
        assertTrue(passenger.getPassportNumber() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testFlightNoAttribute() {
        // Test the flightNo attribute type
        assertNotNull(passenger.getFlightNo());
        assertTrue(passenger.getFlightNo() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testFirstNameAttribute() {
        // Test the firstName attribute type
        assertNotNull(passenger.getFirstName());
        assertTrue(passenger.getFirstName() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testLastNameAttribute() {
        // Test the lastName attribute type
        assertNotNull(passenger.getLastName());
        assertTrue(passenger.getLastName() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testNumLuggageAttribute() {
        // Test the numLuggage attribute type
        assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() <= 5);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testCabinClassAttribute() {
        // Test the cabinClass attribute type
        assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
                   passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testPassengerCreation()
    {
        assertEquals(passportNumber, passenger.getPassportNumber());
        assertEquals(firstName, passenger.getFirstName());
        assertEquals(lastName, passenger.getLastName());
        assertEquals(flightNo, passenger.getFlightNo());
        marksAwarded = marksAwarded + 2;

        assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() <= 5);
        marksAwarded = marksAwarded + 2;

        assertNotNull(passenger.getCabinClass());
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testAssignRandomCabinClass() {
        // Test the assignRandomCabinClass method
        passenger.assignRandomCabinClass();
        assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
                   passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testToString() {
        // Test the toString method
        String expectedString = " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + passenger.getNumLuggage() + " CLASS: " + passenger.getCabinClass();
        assertEquals(expectedString, passenger.toString());
        marksAwarded = marksAwarded + 3;
    }

}
