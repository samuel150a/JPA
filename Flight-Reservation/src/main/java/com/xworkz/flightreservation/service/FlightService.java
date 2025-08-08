package com.xworkz.flightreservation.service;

import com.xworkz.flightreservation.entity.FlightEntity;

import java.util.List;

public interface FlightService {
    public FlightEntity validation(FlightEntity en);
    public void savedFlight(FlightEntity entity);
    public FlightEntity readFlight(FlightEntity entity);
    public FlightEntity updateFlight(FlightEntity entity);
    public FlightEntity deleteFlight(FlightEntity entity);
    public FlightEntity getFlightEntityByAirlines(String airlines);
    public FlightEntity getFlightEntityByPersonName(String personName);



    //4 methods
    public FlightEntity getFlightEntityByDestination(String destination);
    public FlightEntity getFlightEntityByAirport(String airport);
    public List<FlightEntity> getFlightEntityByPrice(Integer price);

}
