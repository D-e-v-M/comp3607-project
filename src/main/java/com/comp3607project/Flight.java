package com.comp3607project;
import java.time.LocalDateTime;
public class Flight{
    
    //Attributes
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;
    
    //Accessors
    public String getFlightNo(){
        return flightNo;
    }
    public String getDestination(){
        return destination;
    }
    public String getOrigin(){
        return origin;
    }
    public LocalDateTime getFlightDate(){
        return flightDate;
    }
    public LuggageManifest getManifest(){
        return manifest;
    }
    
    
    //Methods
    
    public Flight(String flightNo, String destination, String origin, LocalDateTime flightDate){
    }
    
    public String checkInLuggage(Passenger p){
        return "";
    }

    public String printLuggageManifest(){
        return "";
    }
    
    public static int getAllowedLuggage(char cabinClass){
        return 0;
    }
    
    public String toString(){
        return "";
    }
}