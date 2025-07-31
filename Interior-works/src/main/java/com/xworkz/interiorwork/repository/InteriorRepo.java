package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;

public interface InteriorRepo {
    public void savedInterior(InteriorEntity entity);
    public InteriorEntity readInterior(InteriorEntity entity);
    public InteriorEntity updateInterior(InteriorEntity entity);
    public InteriorEntity deleteInterior(InteriorEntity entity);

}
