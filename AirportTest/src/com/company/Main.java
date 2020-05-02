package com.company;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> aircrafts = airport.getAllAircrafts();
        System.out.println(aircrafts);
        System.out.println("Aircrafts count: " + aircrafts.size());
    }
}
