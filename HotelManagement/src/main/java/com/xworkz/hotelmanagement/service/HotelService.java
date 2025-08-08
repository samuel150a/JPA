package com.xworkz.hotelmanagement.service;

import com.xworkz.hotelmanagement.entity.HotelEntity;

import java.util.List;

public interface HotelService {
    public HotelEntity validation(HotelEntity en);
    public void savedHotel(HotelEntity entity);
    public HotelEntity readHotel(HotelEntity entity);
    public HotelEntity updateHotel(HotelEntity entity);
    public HotelEntity deleteHotel(HotelEntity entity);
    public HotelEntity getHotelEntityByName(String name);

    //4methods
    public HotelEntity getHotelEntityByBill(boolean bill);
    public HotelEntity getHotelEntityByFeedback(String feedback);
    List<HotelEntity> getHotelEntityByDish(String dish);
    public List<HotelEntity> getHotelEntityByPrice(Integer price);
    HotelEntity updateTheDish(String updatedish,String name,Integer id);
    //05-08/2025
    HotelEntity updateTheName(String updatedName,String dish,Integer id);
    HotelEntity UpdateThePrice(Integer updatedPrice,String feedback,Integer id);


}
