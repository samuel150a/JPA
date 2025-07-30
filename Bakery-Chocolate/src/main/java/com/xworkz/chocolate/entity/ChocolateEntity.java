package com.xworkz.chocolate.entity;

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
@Table(name = "chocolate_info")

public class ChocolateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="chocolateId")
    private  int chocolateId;

    @Column(name="name")
    private  String name;

    @Column(name="brand")
    private  String brand;

    @Column(name="calories")
    private  int calories;

    @Column(name="shop")
    private  String shop;




}


