package com.xworkz.hotelmanagement.repository;

import com.xworkz.hotelmanagement.entity.HotelEntity;

public interface HotelRepo {
    public void savedHotel(HotelEntity entity);
    public HotelEntity readHotel(HotelEntity entity);
    public HotelEntity updateHotel(HotelEntity entity);
    public HotelEntity deleteHotel(HotelEntity entity);
    public HotelEntity getHotelEntityByName(String name);
    public HotelEntity getHotelEntityByDish(String dish);
    public HotelEntity getHotelEntityByPrice(Integer price);
    public HotelEntity getHotelEntityByBill(boolean bill);
    public HotelEntity getHotelEntityByFeedback(String feedback);
}
