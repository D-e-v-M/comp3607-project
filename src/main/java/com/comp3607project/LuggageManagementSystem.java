package com.comp3607project;

//816030364
import java.io.File;
import java.util.Scanner;
import java.time.LocalDateTime;

public class LuggageManagementSystem {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 00, 00);

        try {
            File flightFile = new File("FlightList.txt");
            Scanner scanner = new Scanner(flightFile);
            String flightData = "";
            int flightCounter = 0;

            // To count the number of flights available
            while (scanner.hasNextLine()) {
                flightData = scanner.nextLine();
                flightCounter++;
            }
            scanner.close();

            scanner = new Scanner(flightFile);
            Flight yyz[] = new Flight[flightCounter];
            String flightNo[] = new String[flightCounter];
            String destination[] = new String[flightCounter];
            String origin[] = new String[flightCounter];

            // Storing all the flight information in an array
            for (int x = 0; x < flightCounter; x++) {
                flightData = scanner.nextLine();
                String[] flightInfo = flightData.split(" ");
                flightNo[x] = flightInfo[0];
                destination[x] = flightInfo[1];
                origin[x] = flightInfo[2];
                yyz[x] = new Flight(flightNo[x], destination[x], origin[x], d);
                System.out.println(yyz[x].toString());
            }
            System.out.println("\n");
            scanner.close();

            File passengerFile = new File("PassengerList.txt");
            scanner = new Scanner(passengerFile);
            String passengerData = "";
            int passengerCounter = 0;

            while (scanner.hasNextLine()) {
                passengerData = scanner.nextLine();
                passengerCounter++;
            }
            scanner.close();

            scanner = new Scanner(passengerFile);
            Passenger p;
            String[] pps = new String[passengerCounter];
            String[] firstNames = new String[passengerCounter];
            String[] lastNames = new String[passengerCounter];
            String[] flightNums = new String[passengerCounter];

            for (int i = 0; i < passengerCounter; i++) {
                boolean flightAvailable = false;
                passengerData = scanner.nextLine();
                String[] splitLine = passengerData.split(" ");

                pps[i] = splitLine[0];
                firstNames[i] = splitLine[1];
                lastNames[i] = splitLine[2];
                flightNums[i] = splitLine[3];

                for (int x = 0; x < flightCounter; x++) {
                    if (flightNums[i].equals(flightNo[x])) {
                        flightAvailable = true;
                        p = new Passenger(pps[i], firstNames[i], lastNames[i], flightNums[i]);
                        System.out.println(p);
                        System.out.println(yyz[x].checkInLuggage(p));
                        System.out.println("\n");
                    }
                }

                if (flightAvailable == false) {
                    System.out.println("Flight Not Available! \n\n");
                }

            }

            for (int i = 0; i < flightCounter; i++) {
                System.out.println(yyz[i].printLuggageManifest());
            }

            scanner.close();
        } catch (Exception e) {

        }
    }
}