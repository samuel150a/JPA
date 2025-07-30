package com.xworkz.petadopt.entity;

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
@Table(name = "pet_info")
public class PetAdoptEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="pet_Id")
    private  int pet_Id;

    @Column(name="petName")
    private  String petName;

    @Column(name="breed")
    private  String breed;

    @Column(name="color")
    private  String color;

    @Column(name="type")
    private  String type;




}


