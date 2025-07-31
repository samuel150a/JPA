package com.xworkz.interiorwork.entity;

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
@Table(name="details")
public class InteriorEntity {
    @Id
    @Column(name="ID")
    private int ID;


    @Column(name="type")
    private String type;

    @Column(name="shop")
    private String shop;

    @Column(name="variety")
    private String variety;

    @Column(name="wood")
    private boolean wood;

    @Column(name="price")
    private int price;

    @Column(name="doordelivery")
    private String doordelivery;
    }

