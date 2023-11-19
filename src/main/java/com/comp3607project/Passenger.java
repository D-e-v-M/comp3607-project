package com.comp3607project;
import java.util.Random;
public class Passenger{
    
    //Attributes
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    //Accessors
    public String getPassportNumber(){
        return passportNumber;
    }
    public String getFlightNo(){
        return flightNo;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getNumLuggage(){
        return numLuggage;
    }
    public char getCabinClass(){
        return cabinClass;
    }
    
    //Methods
    
    public Passenger(String passportNumber, String firstName, String lastName, String flightNo){
       
    }
    
    private void assignRandomCabinClass(){
    }
    
    public String toString(){
        return "";
    }
}