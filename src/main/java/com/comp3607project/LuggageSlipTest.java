package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class LuggageSlipTest implements TestInterface {

  private String passportNumber = "TA890789";
  private String firstName = "Joe";
  private String lastName = "Bean";
  private String flightNo = "BW600";
  private Passenger owner;
  private LocalDateTime d;
  private Flight f;
  private LuggageSlip luggageslip;
  private LuggageSlip luggageslip2;
  private static int marksAwarded = 0;

  private static ArrayList<TestCase> testCasesList;

  static {
    testCasesList = new ArrayList<>();
  }

  public LuggageSlipTest() {
    owner = new Passenger(passportNumber, firstName, lastName, flightNo);
    d = LocalDateTime.of(2023, 1, 23, 10, 0, 0);
    f = new Flight(flightNo, "POS", "ANR", d);
    luggageslip = new LuggageSlip(owner, f);
    luggageslip2 = new LuggageSlip(owner, f, "$105");
  }

  // @BeforeEach
  // public void testAttributeTypes() {
  // owner = new Passenger(passportNumber, firstName, lastName, flightNo);
  // d = LocalDateTime.of(2023, 1, 23, 10, 0, 0);
  // f = new Flight(flightNo, "POS", "ANR", d);
  // luggageslip = new LuggageSlip(owner, f);
  // luggageslip2 = new LuggageSlip(owner, f, "$105");
  // }

  @Test
  public void testOwnerAttribute() {

    try {
      assertNotNull(luggageslip.getOwner());
      assertTrue(luggageslip.getOwner() instanceof Passenger);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testOwnerAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testOwnerAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testluggageSlipIDCounterAttribute() {

    try {
      assertNotNull(luggageslip.getLuggageSlipIDCounter());
      assertTrue(luggageslip.getLuggageSlipIDCounter() >= 1);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testluggageSlipIDCounterAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testluggageSlipIDCounterAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testLuggageSlipIDAttribute() {

    try {
      assertNotNull(luggageslip.getLuggageSlipID());
      assertTrue(luggageslip.getLuggageSlipID() instanceof String);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase("testLuggageSlipIDAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testLuggageSlipIDAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testLabelAttribute() {
    try {
      assertNotNull(luggageslip2.getLabel());
      assertTrue(luggageslip.getLabel() instanceof String);
      marksAwarded = marksAwarded + 1;

      TestCase testCase = new TestCase(" testLabelAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase(" testLabelAttribute", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testLuggageSlipCreation() {
    try {
      assertNotNull(luggageslip);
      assertEquals("", luggageslip.getLabel());
      assertEquals(owner, luggageslip.getOwner());
      marksAwarded = marksAwarded + 3;

      TestCase testCase = new TestCase("testLuggageSlipCreation", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testLuggageSlipCreation", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testOverloadLuggageSlipCreation() {

    try {
      assertNotNull(luggageslip2);
      assertEquals("$105", luggageslip2.getLabel());
      assertEquals(owner, luggageslip2.getOwner());
      marksAwarded = marksAwarded + 3;

      TestCase testCase = new TestCase("testOverloadLuggageSlipCreation", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testOverloadLuggageSlipCreation", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testHasOwner() {
    try {
      assertEquals(luggageslip.getOwner().getPassportNumber(), "TA890789");
      marksAwarded = marksAwarded + 2;

      TestCase testCase = new TestCase("testHasOwner", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testHasOwner", false, e.getMessage());
      testCasesList.add(testCase);

    }

  }

  @Test
  public void testToString() {

    try {
      String text = "";
      for (int i = 1; i <= owner.getNumLuggage(); i++) {
        text += "BW600_Bean_" + i + " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + owner.getNumLuggage()
            + " CLASS: " + owner.getCabinClass() + " $105\n";
      }
      assertEquals(text, luggageslip2.toString());
      marksAwarded = marksAwarded + 2;
      TestCase testCase = new TestCase("testToString", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
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

}
