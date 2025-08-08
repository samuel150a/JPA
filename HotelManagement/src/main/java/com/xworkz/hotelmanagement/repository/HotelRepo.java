package com.xworkz.hotelmanagement.repository;

import com.xworkz.hotelmanagement.entity.HotelEntity;

import java.util.List;

public interface HotelRepo {
    public void savedHotel(HotelEntity entity);
    public HotelEntity readHotel(HotelEntity entity);
    public HotelEntity updateHotel(HotelEntity entity);
    public HotelEntity deleteHotel(HotelEntity entity);
    public HotelEntity getHotelEntityByName(String name);


    //4methods
    public HotelEntity getHotelEntityByBill(boolean bill);
    public HotelEntity getHotelEntityByFeedback(String feedback);
    public List<HotelEntity> getHotelEntityByDish(String dish);
    public List<HotelEntity> getHotelEntityByPrice(Integer price);

    //5-08-25

    HotelEntity updateTheDish(String updatedish,String name,Integer id);
    HotelEntity updateTheName(String updatedName,String dish,Integer id);
    HotelEntity UpdateThePrice(Integer updatedPrice,String feedback,Integer id);
}

