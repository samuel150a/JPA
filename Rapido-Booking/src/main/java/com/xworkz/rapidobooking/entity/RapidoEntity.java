package com.xworkz.rapidobooking.entity;

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
@Table(name="rapido")
@NamedQuery(name="vehicleType", query="select r from RapidoEntity r where r.vehicleType=:vehicleType")
@NamedQuery(name="members", query="select r from RapidoEntity r where r.members=:members")
@NamedQuery(name="pickupLocation", query="select r from RapidoEntity r where r.pickupLocation=:pickupLocation")
@NamedQuery(name="dropLocation", query="select r from RapidoEntity r where r.dropLocation=:dropLocation")
@NamedQuery(name="payment", query="select r from RapidoEntity r where r.payment=:payment")
public class RapidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "members")
    private Integer members;

    @Column(name = "pickupLocation")
    private String pickupLocation;

    @Column(name = "dropLocation")
    private String dropLocation;

    @Column(name = "payment")
    private Integer payment;
}
