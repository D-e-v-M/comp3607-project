package com.comp3607project.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import com.comp3607project.TestCase;
import com.comp3607project.TestInterface;

import org.junit.Test;

public class PassengerTest implements TestInterface {

  String passportNumber = "TA890789";
  String firstName = "Joe";
  String lastName = "Bean";
  String flightNo = "BW600";

  private Passenger passenger;
  private static int marksAwarded = 0;

  private static ArrayList<TestCase> testCasesList;

  static {
    testCasesList = new ArrayList<>();
  }

  public PassengerTest() {
    passenger = new Passenger("TA890789", "Joe", "Bean", "BW600");
  }

  // @BeforeEach
  // public void setUp() {
  // passenger = new Passenger("TA890789", "Joe", "Bean", "BW600");
  // }

  @Test
  public void testPassportNumberAttribute() {
    try {
      assertNotNull(passenger.getPassportNumber());
      assertTrue(passenger.getPassportNumber() instanceof String);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testPassportNumberAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testPassportNumberAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testFlightNoAttribute() {

    try {
      assertNotNull(passenger.getFlightNo());
      assertTrue(passenger.getFlightNo() instanceof String);

      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testFlightNoAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testFlightNoAttribute", false, e.getMessage());
      testCasesList.add(testCase);
    }

  }

  @Test
  public void testFirstNameAttribute() {

    try {
      assertNotNull(passenger.getFirstName());
      assertTrue(passenger.getFirstName() instanceof String);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase(" testFirstNameAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase(" testFirstNameAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testLastNameAttribute() {

    try {
      assertNotNull(passenger.getLastName());
      assertTrue(passenger.getLastName() instanceof String);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testLastNameAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testLastNameAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testNumLuggageAttribute() {

    try {
      assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() <= 5);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testNumLuggageAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testNumLuggageAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testCabinClassAttribute() {
    try {
      assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
          passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
      marksAwarded = marksAwarded + 1;
      TestCase testCase = new TestCase("testCabinClassAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testCabinClassAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testPassengerCreation() {

    try {
      assertEquals(passportNumber, passenger.getPassportNumber());
      assertEquals(firstName, passenger.getFirstName());
      assertEquals(lastName, passenger.getLastName());
      assertEquals(flightNo, passenger.getFlightNo());
      marksAwarded = marksAwarded + 2;

      assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() <= 5);
      marksAwarded = marksAwarded + 2;

      assertNotNull(passenger.getCabinClass());
      marksAwarded = marksAwarded + 1;
      TestCase testCase = new TestCase("testPassengerCreation", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testPassengerCreation", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testAssignRandomCabinClass() {

    try {
      assertTrue(passenger.getCabinClass() == 'F' || passenger.getCabinClass() == 'B' ||
          passenger.getCabinClass() == 'P' || passenger.getCabinClass() == 'E');
      marksAwarded = marksAwarded + 2;

      TestCase testCase = new TestCase("testAssignRandomCabinClass", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testAssignRandomCabinClass", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testToString() {
    try {
      String expectedString = " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + passenger.getNumLuggage() + " CLASS: "
          + passenger.getCabinClass();
      assertEquals(expectedString, passenger.toString());
      marksAwarded = marksAwarded + 3;

      TestCase testCase = new TestCase("testToString", true, "");
      testCasesList.add(testCase);

    } catch (Exception e) {
      TestCase testCase = new TestCase("testToString", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Override
  public int getMarks() {
    return marksAwarded;
  }

  public static ArrayList<TestCase> getTestCasesList() {
    return testCasesList;
  }

  public static void clearList() {
    testCasesList.clear();
  }
}
