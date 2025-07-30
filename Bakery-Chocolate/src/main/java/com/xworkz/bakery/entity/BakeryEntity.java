package com.xworkz.bakery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;



@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "bakery_info")

public class BakeryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="bakeryId")
    private  int bakeryId;

    @Column(name="name")
    private  String name;

    @Column(name="item")
    private  String item;

    @Column(name="price")
    private  int price;

    @Column(name="bill")
    private  String bill;




}


