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
@NamedQuery(name = "fetchAllInterior", query = "SELECT i FROM InteriorEntity i")

//@NamedQuery(name="findByName",query="select a from InteriorEntity a where a.shop='stores'")
//@NamedQuery(name="type",query="select a from InteriorEntity a where a.type=:type")
//@NamedQuery(name="shop",query="select a  from InteriorEntity a where a.shop=:shop")
//@NamedQuery(name="variety",query="select a from InteriorEntity a where a.variety=:variety")
//@NamedQuery(name="wood",query="select a from InteriorEntity a where a.wood=:wood")
// query = "UPDATE EmployeeEntity e SET e.salary = :salary WHERE e.id = :id AND e.company = :company"
// 4 named query
@NamedQuery(name="entitySpecificType",query = "select a from InteriorEntity a where a.type='wood'")
@NamedQuery(name="entitySpecificvariety",query="select v from InteriorEntity v where v.variety='hotel'")
@NamedQuery(name="getprice",query ="select z from InteriorEntity z where z.price=:price")
@NamedQuery(name="entityDoorDelivery",query ="select d from InteriorEntity d where d.doordelivery=:doordelivery")

@NamedQuery(
        name = "updateById",
        query = "UPDATE InteriorEntity e SET e.type = :type, e.shop = :shop WHERE e.ID = :ID"
)
@NamedQuery(name="updateByPrice",
        query="UPDATE InteriorEntity p SET p.variety=:variety WHERE p.price=:price "
      )


@NamedQuery(name="updateByShop"
        ,query="update InteriorEntity s set s.wood=:wood where s.shop=:shop And s.ID=:ID "
)

@NamedQuery(name="getAllVarietynames"
        ,query="select v.variety from InteriorEntity v")

@NamedQuery(name="getAllPrice"
          ,query="select p.price from InteriorEntity p"
)
@NamedQuery(name="getAllWood"
        ,query="select w.wood from InteriorEntity w"
)
@NamedQuery(name="FetchTwoColumns"
        ,query="select i.ID , i.variety from InteriorEntity i"
)


public class InteriorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;


    @Column(name="type")
    private String type;

    @Column(name="shop")
    private String shop;

    @Column(name="variety")
    private String variety;

    @Column(name="wood")
    private Boolean wood;

    @Column(name="price")
    private Integer price;

    @Column(name="doordelivery")
    private String doordelivery;
}