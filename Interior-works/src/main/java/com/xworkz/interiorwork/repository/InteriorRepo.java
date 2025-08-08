package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;

import java.util.List;
import java.util.Map;

public interface InteriorRepo {
    public void savedInterior(InteriorEntity entity);
    public InteriorEntity readInterior(InteriorEntity entity);
    public InteriorEntity updateInterior(InteriorEntity entity);
    public InteriorEntity deleteInterior(InteriorEntity entity);
    public InteriorEntity getInteriorEntityByName(String shop);
     InteriorEntity getInteriorEntityBytype(String type);
     InteriorEntity getInteriorEntityByvariety(String variety);
     InteriorEntity getInteriorEntityBywood(boolean wood);

     List<InteriorEntity> fetchAllInterior(InteriorEntity entity);

     //4 methods
    List<InteriorEntity> getBySpecifictype(String entity);
    List<InteriorEntity> getBYSpecificvariety(String entity);
     InteriorEntity getInteriorEntityByPrice(Integer price);
     InteriorEntity getInteriorEntityBydoordelivery(String doordelivery);
     InteriorEntity findByNameByTypedQuery(String n);

    //05-08/2025
    public InteriorEntity updateById(String updatedType,String updatedShop,Integer Id);
    InteriorEntity updateByPrice(String updatedVariety,Integer Price);
    InteriorEntity updateByShop(Boolean updateWood,String updateShop,Integer Id);
    List<String> getAllVarietynames();
    List<Integer>getAllPrice();
    List<Object>getAllWood();
    List<Object[]> FetchTwoColumns();



}