package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuggageSlipTest{

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

    @BeforeEach
    public void testAttributeTypes() {
        owner = new Passenger(passportNumber, firstName, lastName, flightNo);
        d = LocalDateTime.of(2023, 1, 23, 10, 0, 0);
        f = new Flight(flightNo, "POS", "ANR",d);
        luggageslip = new LuggageSlip(owner, f);
        luggageslip2 = new LuggageSlip(owner, f, "$105");
    }


    @Test
    public void testOwnerAttribute()
    {
        assertNotNull(luggageslip.getOwner());
        assertTrue(luggageslip.getOwner() instanceof Passenger);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testluggageSlipIDCounterAttribute()
    {
        assertNotNull(luggageslip.getLuggageSlipIDCounter());
        assertTrue(luggageslip.getLuggageSlipIDCounter() >= 1);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testLuggageSlipIDAttribute()
    {
        assertNotNull(luggageslip.getLuggageSlipID());
        assertTrue(luggageslip.getLuggageSlipID() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testLabelAttribute()
    {
        assertNotNull(luggageslip2.getLabel());
        assertTrue(luggageslip.getLabel() instanceof String);
        marksAwarded = marksAwarded + 1;
    }

    @Test
    public void testLuggageSlipCreation(){
        assertNotNull(luggageslip);
        assertEquals("", luggageslip.getLabel());
        assertEquals(owner, luggageslip.getOwner());
        marksAwarded = marksAwarded + 3;
    }

    @Test
    public void testOverloadLuggageSlipCreation(){
        assertNotNull(luggageslip2);
        assertEquals("$105", luggageslip2.getLabel());
        assertEquals(owner, luggageslip2.getOwner());
        marksAwarded = marksAwarded + 3;
    }

    @Test
    public void testHasOwner(){
        assertEquals(luggageslip.getOwner().getPassportNumber(), "TA890789");
        marksAwarded = marksAwarded + 2;
    }

    @Test
    public void testToString()
    {   
        String text = "";
        for(int i=1; i<=owner.getNumLuggage(); i++)
        {
            text += "BW600_Bean_" + i + " PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: " + owner.getNumLuggage() + " CLASS: " + owner.getCabinClass() + " $105";
        }
        assertEquals(text, luggageslip2.toString());
        marksAwarded = marksAwarded + 2;
    }

    @AfterAll
    static void allocateMarks() {
        System.out.println("Allocating marks: " + marksAwarded);
    }

    public static int getMarks()
    {
        return marksAwarded;
    }
    
}
