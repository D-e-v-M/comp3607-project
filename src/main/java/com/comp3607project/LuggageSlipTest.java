package com.comp3607project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import org.junit.Test;

public class LuggageSlipTest{

    String passportNumber = "TA890789";
    String firstName = "Joe";
    String lastName = "Bean";
    String flightNo = "BW600";
    Passenger owner = new Passenger(passportNumber, firstName, lastName, flightNo);
    
    LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 0, 0);
    Flight f = new Flight(flightNo, "POS", "ANR",d);
    LuggageSlip luggageslip = new LuggageSlip(owner, f);
    LuggageSlip luggageslip2 = new LuggageSlip(owner, f, "$105");
    
    @Test
    public void testOwner()
    {
        assertNotNull(luggageslip.getOwner());
        assertTrue(luggageslip.getOwner() instanceof Passenger);
    }

    @Test
    public void testluggageSlipIDCounter()
    {
        assertNotNull(luggageslip.getLuggageSlipIDCounter());
        assertTrue(luggageslip.getLuggageSlipIDCounter() >= 1);
    }

    @Test
    public void testLuggageSlipID()
    {
        assertNotNull(luggageslip.getLuggageSlipID());
        assertEquals("BW600_Bean",luggageslip.getLuggageSlipID());
    }

    @Test
    public void testLabel()
    {
        assertNotNull(luggageslip.getLabel());
        assertNotNull(luggageslip2.getLabel());
        assertTrue(luggageslip.getLabel() == "" && luggageslip2.getLabel() == "$105");
    }

    @Test
    public void testLuggageSlip(){
        assertNotNull(luggageslip);
        assertEquals(luggageslip.getLabel(), "");
        assertEquals(luggageslip.getOwner(), owner);
    }

    @Test
    public void testOverloadLuggageSlip(){
        assertNotNull(luggageslip2);
        assertEquals(luggageslip2.getLabel(), "$105");
        assertEquals(luggageslip2.getOwner(), owner);
    }

    @Test
    public void testHasOwner(){
        assertEquals(luggageslip.getOwner().getPassportNumber(), "TA890789");
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

    }
    
}
