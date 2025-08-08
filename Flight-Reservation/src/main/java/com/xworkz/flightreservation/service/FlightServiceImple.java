package com.xworkz.flightreservation.service;

import com.xworkz.flightreservation.entity.FlightEntity;
import com.xworkz.flightreservation.repository.FlightRepo;
import com.xworkz.flightreservation.repository.FlightRepoImple;

import java.util.Collections;
import java.util.List;

public class FlightServiceImple implements FlightService {
    FlightRepo flightRepo = new FlightRepoImple();

    @Override
    public FlightEntity validation(FlightEntity en) {
        if (en != null) {
            if (en.getPrice() != null && en.getPrice() < 10000) {
                flightRepo.savedFlight(en);
            }
        }
        return null;
    }

    @Override
    public void savedFlight(FlightEntity entity) {
        validation(entity);
    }

    @Override
    public FlightEntity readFlight(FlightEntity entity) {
        return flightRepo.readFlight(entity);
    }

    @Override
    public FlightEntity updateFlight(FlightEntity entity) {
        return flightRepo.updateFlight(entity);
    }

    @Override
    public FlightEntity deleteFlight(FlightEntity entity) {
        return flightRepo.deleteFlight(entity);
    }

    @Override
    public FlightEntity getFlightEntityByAirlines(String airlines) {
        return flightRepo.getFlightEntityByAirlines(airlines);
    }

    @Override
    public FlightEntity getFlightEntityByPersonName(String personName) {
        return flightRepo.getFlightEntityByPersonName(personName);
    }



    @Override
    public FlightEntity getFlightEntityByDestination(String destination) {
        return flightRepo.getFlightEntityByDestination(destination);
    }

    @Override
    public FlightEntity getFlightEntityByAirport(String airport) {
        return flightRepo.getFlightEntityByAirport(airport);
    }

    @Override
    public List<FlightEntity> getFlightEntityByPrice(Integer price) {
        return flightRepo.getFlightEntityByPrice(price);
    }
}
