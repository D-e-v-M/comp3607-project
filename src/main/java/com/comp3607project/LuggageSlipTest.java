package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
  private static String resultsOutput = "\n";

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
      resultsOutput += "Owner Attribute " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testOwnerAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testOwnerAttribute", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "Owner Attribute " + 0 + "\n";

    }

  }

  @Test
  public void testluggageSlipIDCounterAttribute() {

    try {
      assertNotNull(luggageslip.getLuggageSlipIDCounter());
      assertTrue(luggageslip.getLuggageSlipIDCounter() >= 1);
      marksAwarded = marksAwarded + 1;
      resultsOutput += "luggageSlipIDCounter Attribute " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testluggageSlipIDCounterAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testluggageSlipIDCounterAttribute", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "luggageSlipIDCounter Attribute " + 0 + "\n";

    }

  }

  @Test
  public void testLuggageSlipIDAttribute() {

    try {
      assertNotNull(luggageslip.getLuggageSlipID());
      assertTrue(luggageslip.getLuggageSlipID() instanceof String);
      marksAwarded = marksAwarded + 1;
      resultsOutput += "LuggageSlipID Attribute " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testLuggageSlipIDAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testLuggageSlipIDAttribute", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "LuggageSlipID Attribute " + 0 + "\n";

    }

  }

  @Test
  public void testLabelAttribute() {
    try {
      assertNotNull(luggageslip2.getLabel());
      assertTrue(luggageslip.getLabel() instanceof String);
      marksAwarded = marksAwarded + 1;
      resultsOutput += "Label Attribute " + marksAwarded + "\n";

      TestCase testCase = new TestCase(" testLabelAttribute", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase(" testLabelAttribute", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "Label Attribute " + 0 + "\n";

    }

  }

  @Test
  public void testLuggageSlipCreation() {
    try {
      assertNotNull(luggageslip);
      assertEquals("", luggageslip.getLabel());
      assertEquals(owner, luggageslip.getOwner());
      marksAwarded = marksAwarded + 3;
      resultsOutput += "LuggageSlip Method " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testLuggageSlipCreation", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testLuggageSlipCreation", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "LuggageSlip Method " + 0 + "\n";

    }

  }

  @Test
  public void testOverloadLuggageSlipCreation() {

    try {
      assertNotNull(luggageslip2);
      assertEquals("$105", luggageslip2.getLabel());
      assertEquals(owner, luggageslip2.getOwner());
      marksAwarded = marksAwarded + 3;
      resultsOutput += "OverloadLuggageSlip Method " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testOverloadLuggageSlipCreation", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testOverloadLuggageSlipCreation", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "OverloadLuggageSlip Method " + 0 + "\n";
    }

  }

  @Test
  public void testHasOwner() {
    try {
      assertEquals(luggageslip.getOwner().getPassportNumber(), "TA890789");
      marksAwarded = marksAwarded + 2;
      resultsOutput += "HasOwner Method " + marksAwarded + "\n";

      TestCase testCase = new TestCase("testHasOwner", true, "");
      testCasesList.add(testCase);
    } catch (AssertionError e) {
      TestCase testCase = new TestCase("testHasOwner", false, e.getMessage());
      testCasesList.add(testCase);
      resultsOutput += "HasOwner Method " + 0 + "\n";

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
        resultsOutput += "LuggageSlip Class Score: " + marksAwarded + " /14 \n";
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
