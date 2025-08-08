package com.xworkz.interiorwork.service;

import com.xworkz.interiorwork.entity.InteriorEntity;

import java.util.List;

public interface InteriorService {
    InteriorEntity validation(InteriorEntity en);
    public void savedInterior(InteriorEntity entity);
    public InteriorEntity readInterior(InteriorEntity entity);
    public InteriorEntity updateInterior(InteriorEntity entity);
    public InteriorEntity deleteInterior(InteriorEntity entity);
    List<InteriorEntity> fetchAllInterior(InteriorEntity entity);
    public InteriorEntity getInteriorEntityByName(String shop);
    public InteriorEntity getInteriorEntityBytype(String type);
    public InteriorEntity getInteriorEntityByvariety(String variety);
    public InteriorEntity getInteriorEntityBywood(boolean wood );



    //4 methods
    List<InteriorEntity> getBySpecifictype(String entity);
    List<InteriorEntity> getBYSpecificvariety(String entity);
    public InteriorEntity getInteriorEntityByPrice(Integer price);
    public InteriorEntity getInteriorEntityBydoordelivery(String doordelivery);


}
