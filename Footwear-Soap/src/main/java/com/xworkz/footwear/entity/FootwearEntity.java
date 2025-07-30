package com.xworkz.footwear.entity;

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
@Table(name = "footwear_info")
public class FootwearEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="footwear_Id")
    private  int footwear_Id;

    @Column(name="person")
    private  String person;

    @Column(name="color")
    private  String color;

    @Column(name="owner")
    private  String owner;

    @Column(name="leather")
    private  String leather;




}


