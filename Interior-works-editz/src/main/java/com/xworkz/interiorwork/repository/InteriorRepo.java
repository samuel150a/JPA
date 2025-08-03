package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;

public interface InteriorRepo {
    public void savedInterior(InteriorEntity entity);
    public InteriorEntity readInterior(InteriorEntity entity);
    public InteriorEntity updateInterior(InteriorEntity entity);
    public InteriorEntity deleteInterior(InteriorEntity entity);
    public InteriorEntity getInteriorEntityByName(String shop);
    public InteriorEntity getInteriorEntityBytype(String type);
    public InteriorEntity getInteriorEntityByvariety(String variety);
    public InteriorEntity getInteriorEntityBywood(boolean wood);
    public InteriorEntity getInteriorEntityByPrice(Integer price);
    public InteriorEntity getInteriorEntityBydoordelivery(String doordelivery);

}