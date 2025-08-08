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
//@NamedQuery(name="name", query="select h from HotelEntity h where h.name=:name")
//@NamedQuery(name="dish", query="select h from HotelEntity h where h.dish=:dish")
//@NamedQuery(name="price", query="select h from HotelEntity h where h.price=:price")
//4 named query
@NamedQuery(name="getbill", query="select h from HotelEntity h where h.bill=:bill")
@NamedQuery(name="getfeedback", query="select h from HotelEntity h where h.feedback=:feedback")
@NamedQuery(name="getDish",query="select d from HotelEntity d where d.dish='biryani'")
@NamedQuery(name="getPrice",query="select p from HotelEntity p where p.price='200'")


//5-08-25

@NamedQuery(  name="updateTheDish"
        ,query="update  HotelEntity d set d.dish=:dish where d.name=:name and d.ID=:ID")

@NamedQuery(name="updateTheName"
         ,query="update HotelEntity n set n.name=:name where n.dish=:dish and  n.ID=:ID")

@NamedQuery(name="UpdateThePrice"
                   ,query="update HotelEntity p set p.price=:price where p.feedback=:feedback and p.ID=:ID")







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
