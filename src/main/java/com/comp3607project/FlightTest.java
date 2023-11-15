package com.comp3607project;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightTest implements TestInterface {
    private Flight flight;
    LocalDateTime creationDate;
    private static int marksAwarded = 0;

    private ArrayList<String> testCasesList;
    private ArrayList<String> passStatusList;
    private ArrayList<String> feedbackList;

    public FlightTest() {
        testCasesList = new ArrayList<>();
        passStatusList = new ArrayList<>();
        feedbackList = new ArrayList<>();

        creationDate = LocalDateTime.now();
        flight = new Flight("FL123", "New York", "Los Angeles", creationDate);
    }

    // @BeforeEach
    // public void testAttributeTypes() {
    // creationDate = LocalDateTime.now();
    // flight = new Flight("FL123", "New York", "Los Angeles", creationDate);
    // }

    @Test
    public void testFlightNoAttribute() {
        String flightNo = flight.getFlightNo();

        assertNotNull(flightNo);
        assertTrue(flightNo instanceof String);
        marksAwarded = marksAwarded + 1;

        testCasesList.add("testFlightNoAttribute");
        passStatusList.add("Passed");
        feedbackList.add("WHatever");
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
    public void testFlightCreation() {
        assertEquals("FL123", flight.getFlightNo());
        assertEquals("New York", flight.getDestination());
        assertEquals("Los Angeles", flight.getOrigin());
        assertEquals(creationDate, flight.getFlightDate());
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testCheckInLuggage() {
        Passenger passenger = new Passenger("HF546645", "Jane", "Doe", "FL123");
        String result = flight.checkInLuggage(passenger);
        double excessCost = flight.getManifest().getExcessLuggageCost(passenger.getNumLuggage(),
                flight.getAllowedLuggage(passenger.getCabinClass()));
        String expected = "";
        if (passenger.getNumLuggage() == 0)
            expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0) + "."
                    + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                    + passenger.getCabinClass() + "\n" + "No Luggage to add\n";
        else if (excessCost == 0)
            expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0) + "."
                    + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                    + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")\n";
        else
            expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0) + "."
                    + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                    + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")" + " $"
                    + excessCost + "\n";

        assertEquals(expected, result);

        Passenger invalidPassenger = new Passenger("HF546645", "Jane", "Doe", "HF939");
        result = flight.checkInLuggage(invalidPassenger);
        assertEquals("Invalid flight", result);
        marksAwarded = marksAwarded + 5;
    }

    @Test
    public void testPrintLuggageManifest() {
        String manifestString = flight.printLuggageManifest();
        assertNotNull(manifestString);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testGetAllowedLuggage() {
        assertEquals(3, flight.getAllowedLuggage('F'));
        assertEquals(2, flight.getAllowedLuggage('B'));
        assertEquals(1, flight.getAllowedLuggage('P'));
        assertEquals(0, flight.getAllowedLuggage('E'));
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testToString() {
        Flight flight = new Flight("FL123", "New York", "Los Angeles", LocalDateTime.now());
        String flightString = flight.toString();
        assertNotNull(flightString);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void sendDataToGenerator() throws FileNotFoundException, DocumentException {
        DocumentBuilder generator = new PDFGenerator();

        generator.addTestCases(testCasesList);
        generator.addPassStatus(passStatusList);
        generator.addFeedback(feedbackList);

        System.out.println(testCasesList.size());

        generator.createDocument();
    }

    @Override
    public int getMarks() {
        return marksAwarded;
    }
}
