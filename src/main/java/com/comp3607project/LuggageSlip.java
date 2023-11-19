package com.comp3607project;
public class LuggageSlip{
    
    private Passenger owner;
    private static int luggageSlipIDCounter = 1;  //static since ALL objects of this class share this one attribute
    private String luggageSlipID;
    private String label;
    
    public Passenger getOwner(){
        return owner;
    }
    public int getLuggageSlipIDCounter(){
        return luggageSlipIDCounter;
    }
    public String getLuggageSlipID(){
        return luggageSlipID;
    }
    public String getLabel(){
        return label;
    }
    
    public LuggageSlip(Passenger p, Flight f){
        
    }
    public LuggageSlip(Passenger p, Flight f, String label){
        
    }
    public boolean hasOwner(String passportNumber){
        return true;
    }
    
    public String toString(){
        return "";    
    }

}