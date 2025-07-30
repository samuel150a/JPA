package com.xworkz.passport.entity;

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
@Table(name = "passport_info")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="ID")
    private  int ID;

    @Column(name="name")
    private  String name;

    @Column(name="country")
    private  String country;

    @Column(name="Sonof")
    private  String Sonof;

    @Column(name="valid")
    private  String valid;




}


