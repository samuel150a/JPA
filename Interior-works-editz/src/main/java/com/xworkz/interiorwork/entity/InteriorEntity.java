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
@Table(name="peacock")
//@NamedQuery(name="findByName",query="select a from InteriorEntity a where a.shop='stores'")
@NamedQuery(name="type",query="select a from InteriorEntity a where a.type=:type")
@NamedQuery(name="shop",query="select a  from InteriorEntity a where a.shop=:shop")
@NamedQuery(name="variety",query="select a from InteriorEntity a where a.variety=:variety")
@NamedQuery(name="wood",query="select a from InteriorEntity a where a.wood=:wood")
@NamedQuery(name="price",query ="select a from InteriorEntity a where a.price=:price")
@NamedQuery(name="doordelivery",query = "select a from InteriorEntity a where a.doordelivery=:doordelivery")

public class InteriorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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