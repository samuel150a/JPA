package com.xworkz.hotelmanagement.runner;

import com.xworkz.hotelmanagement.entity.HotelEntity;
import com.xworkz.hotelmanagement.service.HotelService;
import com.xworkz.hotelmanagement.service.HotelServiceImple;

public class HotelRunner {
    public static void main(String[] args) {
        HotelEntity entity = new HotelEntity();
        entity.setName("Taj");
        entity.setDish("Paneer");
        entity.setPrice(850);
        entity.setBill(true);
        entity.setFeedback("Good service");

        HotelService hotelService = new HotelServiceImple();
         hotelService.savedHotel(entity);

//        HotelEntity ref = hotelService.readHotel(entity);
//        System.out.println("Read data from DB:");
//        System.out.println(ref);

        // hotelService.updateHotel(entity);
        // hotelService.deleteHotel(entity);
        // hotelService.getHotelEntityByName("Taj");
        // hotelService.getHotelEntityByDish("Paneer");
        // hotelService.getHotelEntityByPrice(850);
        // hotelService.getHotelEntityByBill(true);
       // hotelService.getHotelEntityByFeedback("Good service");
    }
}
