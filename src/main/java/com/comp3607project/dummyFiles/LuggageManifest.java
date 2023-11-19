package com.comp3607project.dummyFiles;
import java.util.ArrayList;
public class LuggageManifest{
    
    
    private static ArrayList<LuggageSlip> slips;
    
    public ArrayList<LuggageSlip> getSlips(){
        return slips;
    }
    
    public LuggageManifest(){
    }
    
    public String addLuggage(Passenger p, Flight f){
        return "";
    }
    
    public double getExcessLuggageCost(int numPieces, int numAllowedPieces){
        return 0.00;                   
    }
    
    public String getExcessLuggageCostByPassenger(String passportNumber){
        return "";
    }
    
    public String toString(){
        return "";
    }
}