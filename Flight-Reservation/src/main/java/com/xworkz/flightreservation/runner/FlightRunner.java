package com.xworkz.flightreservation.runner;

import com.xworkz.flightreservation.entity.FlightEntity;
import com.xworkz.flightreservation.service.FlightService;
import com.xworkz.flightreservation.service.FlightServiceImple;

import java.util.List;

public class FlightRunner {
    public static void main(String[] args) {
        FlightEntity entity = new FlightEntity();
        entity.setAirlines("Indigo");
        entity.setPersonName("John");
        entity.setPrice(8500);
        entity.setDestination("Delhi");
        entity.setAirport("Kempegowda");

        FlightService flightService = new FlightServiceImple();

         //flightService.savedFlight(entity);

//        FlightEntity ref = flightService.readFlight(entity);
//        System.out.println("Read data from DB:");
//        System.out.println(ref);

        // flightService.updateFlight(entity);
        // flightService.deleteFlight(entity);
        // flightService.getFlightEntityByAirlines("Indigo");
        // flightService.getFlightEntityByPersonName("John");
        // flightService.getFlightEntityByPrice(8500);
        // flightService.getFlightEntityByDestination("Delhi");
       // flightService.getFlightEntityByAirport("Kempegowda");
        //4methods
        flightService.getFlightEntityByDestination("Delhi");
        flightService.getFlightEntityByAirport("canadaair");
        List<FlightEntity> disp=flightService.getFlightEntityByPrice(6500);
        {
            for(FlightEntity e:disp)
            {
                System.out.println(e);
            }
        }
    }
}
