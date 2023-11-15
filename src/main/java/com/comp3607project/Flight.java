package com.comp3607project;

//816030364
import java.time.LocalDateTime;

public class Flight {
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;

    public Flight(String flightNo, String destination, String origin, LocalDateTime flightDate) {
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = new LuggageManifest();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public LuggageManifest getManifest() {
        return manifest;
    }

    public String checkInLuggage(Passenger p) {
        String flightNoCheck;

        if (p.getFlightNo().equals(this.flightNo)) {
            return manifest.addLuggage(p, this);
        }

        else {
            flightNoCheck = "Invalid Flight";
        }

        return flightNoCheck;
    }

    public String printLuggageManifest() {
        return manifest.toString();
    }

    public int getAllowedLuggage(char cabinClass) {
        int num = 0;
        if (cabinClass == 'F') {
            num = 3;

        }
        if (cabinClass == 'B') {
            num = 2;

        }
        if (cabinClass == 'P') {
            num = 1;

        }
        if (cabinClass == 'E') {
            num = 0;
        }
        return num;
    }

    public String toString() {
        String flightDetails = getFlightNo() + " DESTINATION: "
                + getDestination() + " ORIGIN: " + getOrigin() + " " +
                getFlightDate();
        return flightDetails;
    }
}