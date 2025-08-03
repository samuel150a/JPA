package com.xworkz.hotelmanagement.entity;

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
@Table(name="hotel")
@NamedQuery(name="name", query="select h from HotelEntity h where h.name=:name")
@NamedQuery(name="dish", query="select h from HotelEntity h where h.dish=:dish")
@NamedQuery(name="price", query="select h from HotelEntity h where h.price=:price")
@NamedQuery(name="bill", query="select h from HotelEntity h where h.bill=:bill")
@NamedQuery(name="feedback", query="select h from HotelEntity h where h.feedback=:feedback")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="name")
    private String name;

    @Column(name="dish")
    private String dish;

    @Column(name="price")
    private Integer price;

    @Column(name="bill")
    private boolean bill;

    @Column(name="feedback")
    private String feedback;
}
