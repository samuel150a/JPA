package com.xworkz.soap.entity;

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
@Table(name = "soap_info")
public class SoapEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="soap_Id")
    private  int soap_Id;

    @Column(name="type")
    private  String type;

    @Column(name="cost")
    private  int cost;

    @Column(name="brand")
    private  String brand;

    @Column(name="chemical")
    private  String chemical;




}


