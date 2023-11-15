package com.comp3607project;

//816030364
import java.util.Random;

public class Passenger {
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    private char firstNameLetter;

    public Passenger(String passportNumber, String firstName, String lastName, String flightNo) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        firstNameLetter = this.firstName.charAt(0);
        this.lastName = lastName;
        this.flightNo = flightNo;
        assignRandomCabinClass();
        assignRandomNumLuggage();
    }

    private void assignRandomNumLuggage() {
        Random randomNumLuggage = new Random();
        this.numLuggage = randomNumLuggage.nextInt(4);
    }

    private void assignRandomCabinClass() {
        char[] classes = { 'F', 'B', 'P', 'E' };
        Random randomCabinClass = new Random();
        this.cabinClass = classes[randomCabinClass.nextInt(4)];
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getFirstNameLetter() {
        return firstNameLetter;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumLuggage() {
        return numLuggage;
    }

    public char getCabinClass() {
        return cabinClass;
    }

    public String toString() {
        String passengerDetails = "PP NO. " + getPassportNumber() + " NAME: "
                + getFirstNameLetter() + " " + getLastName() + " NUMLUGGAGE: " +
                getNumLuggage() + " CLASS: " + getCabinClass();
        return passengerDetails;
    }
}

// https://www.w3schools.com/java/default.asp - source used to learn how to get
// the first letter of a word