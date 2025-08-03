package com.xworkz.flightreservation.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "flight")
@NamedQuery(name = "airlines", query = "select f from FlightEntity f where f.airlines = :airlines")
@NamedQuery(name = "personName", query = "select f from FlightEntity f where f.personName = :personName")
@NamedQuery(name = "price", query = "select f from FlightEntity f where f.price = :price")
@NamedQuery(name = "destination", query = "select f from FlightEntity f where f.destination = :destination")
@NamedQuery(name = "airport", query = "select f from FlightEntity f where f.airport = :airport")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "airlines")
    private String airlines;

    @Column(name = "personName")
    private String personName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "destination")
    private String destination;

    @Column(name = "airport")
    private String airport;
}
