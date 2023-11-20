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
    private static String resultsOutput = "\n";

    private static ArrayList<TestCase> testCasesList;

    static {
        testCasesList = new ArrayList<>();
    }

    public FlightTest() {
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
        try {
            String flightNo = flight.getFlightNo();

            assertNotNull(flightNo);
            assertTrue(flightNo instanceof String);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "FlightNo Attribute " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testFlightNoAttribute", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testFlightNoAttribute", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "FlightNo Attribute " + 0 + "\n";
        }

    }

    @Test
    public void testDestinationAttribute() {

        try {
            String destination = flight.getDestination();

            assertNotNull(destination);
            assertTrue(destination instanceof String);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "Destination Attribute " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testDestinationNoAttribute", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testDestinationNoAttribute", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "Destination Attribute " + 0 + "\n";
        }

    }

    @Test
    public void testOriginAttribute() {

        try {
            String origin = flight.getOrigin();

            assertNotNull(origin);
            assertTrue(origin instanceof String);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "Origin Attribute " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testOriginAttribute", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testOriginAttribute", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "Origin Attribute " + 0 + "\n";

        }

    }

    @Test
    public void testFlightDateAttribute() {

        try {
            LocalDateTime flightDate = flight.getFlightDate();

            assertNotNull(flightDate);
            assertTrue(flightDate instanceof LocalDateTime);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "FlightDate Attribute " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testFlightDateAttribute", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testFlightDatettribute", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "FlightDate Attribute " + 0 + "\n";

        }

    }

    @Test
    public void testManifestAttribute() {

        try {
            LuggageManifest manifest = flight.getManifest();

            assertNotNull(manifest);
            assertTrue(manifest instanceof LuggageManifest);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "Manifest Attribute " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testManifestAttribute", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testManifestAttribute", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "Manifest Attribute " + 0 + "\n";

        }

    }

    @Test
    public void testFlightCreation() {

        try {
            assertEquals("FL123", flight.getFlightNo());
            assertEquals("New York", flight.getDestination());
            assertEquals("Los Angeles", flight.getOrigin());
            assertEquals(creationDate, flight.getFlightDate());
            marksAwarded = marksAwarded + 2;
            resultsOutput += "Flight Method " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testFlightCreation", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testFlightCreation", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "Flight Method " + 0 + "\n";
        }

    }

    @Test
    public void testCheckInLuggage() {

        try {
            Passenger passenger = new Passenger("HF546645", "Jane", "Doe", "FL123");
            String result = flight.checkInLuggage(passenger);
            double excessCost = flight.getManifest().getExcessLuggageCost(passenger.getNumLuggage(),
                    flight.getAllowedLuggage(passenger.getCabinClass()));
            String expected = "";
            if (passenger.getNumLuggage() == 0)
                expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0)
                        + "."
                        + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                        + passenger.getCabinClass() + "\n" + "No Luggage to add\n";
            else if (excessCost == 0)
                expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0)
                        + "."
                        + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                        + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")\n";
            else
                expected = "PP NO." + passenger.getPassportNumber() + " NAME:" + passenger.getFirstName().charAt(0)
                        + "."
                        + passenger.getLastName().toUpperCase() + " NUMLUGGAGE:" + passenger.getNumLuggage() + " CLASS:"
                        + passenger.getCabinClass() + " Pieces added:" + "(" + passenger.getNumLuggage() + ")" + " $"
                        + excessCost + "\n";

            assertEquals(expected, result);

            Passenger invalidPassenger = new Passenger("HF546645", "Jane", "Doe", "HF939");
            result = flight.checkInLuggage(invalidPassenger);
            assertEquals("Invalid flight", result);
            marksAwarded = marksAwarded + 5;
            resultsOutput += "CheckInLuggage Method " + marksAwarded + "\n";

            TestCase testCase = new TestCase("testCheckInLuggage", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testCheckInLuggage", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "CheckInLuggage Method " + 0 + "\n";

        }

    }

    @Test
    public void testPrintLuggageManifest() {

        try {
            String manifestString = flight.printLuggageManifest();
            assertNotNull(manifestString);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "PrintLuggageManifest Method " + marksAwarded + "\n";
            TestCase testCase = new TestCase("testPrintLuggageManifest", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testPrintLuggageManifest", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "PrintLuggageManifest Method " + 0 + "\n";

        }

    }

    @Test
    public void testGetAllowedLuggage() {

        try {
            assertEquals(3, flight.getAllowedLuggage('F'));
            assertEquals(2, flight.getAllowedLuggage('B'));
            assertEquals(1, flight.getAllowedLuggage('P'));
            assertEquals(0, flight.getAllowedLuggage('E'));
            marksAwarded = marksAwarded + 2;
            resultsOutput += "GetAllowedLuggage Method " + marksAwarded + "\n";
            TestCase testCase = new TestCase("testGetAllowedLuggage", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testGetAllowedLuggage", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "GetAllowedLuggage Method " + 0 + "\n";

        }

    }

    @Test
    public void testToString() {

        try {
            Flight flight = new Flight("FL123", "New York", "Los Angeles", LocalDateTime.now());
            String flightString = flight.toString();
            assertNotNull(flightString);
            marksAwarded = marksAwarded + 1;
            resultsOutput += "ToString Method " + marksAwarded + "\n";
            TestCase testCase = new TestCase("testToString", true, "");
            testCasesList.add(testCase);
        } catch (AssertionError e) {
            TestCase testCase = new TestCase("testToString", false, e.getMessage());
            testCasesList.add(testCase);
            resultsOutput += "ToString Method " + 0 + "\n";

        }

    }

    @Override
    public String getOverallOutput() {
        resultsOutput += "Flight Class Score: " + marksAwarded + " /16 \n";
        resultsOutput += "-------------------------------------------------\n";
        return resultsOutput;
    }

    @Override
    public int getMarks()
    {
        return marksAwarded;
    }


    public static ArrayList<TestCase> getTestCasesList() {
        return testCasesList;
    }

    public static void clearList() {
        testCasesList.clear();
    }
}
