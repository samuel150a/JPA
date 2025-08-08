package com.xworkz.hotelmanagement.runner;

import com.xworkz.hotelmanagement.entity.HotelEntity;
import com.xworkz.hotelmanagement.service.HotelService;
import com.xworkz.hotelmanagement.service.HotelServiceImple;

import java.util.List;

public class HotelRunner {
    public static void main(String[] args) {
        HotelEntity entity = new HotelEntity();
        entity.setName("Taj");
        entity.setDish("Paneer");
        entity.setPrice(850);
        entity.setBill(true);
        entity.setFeedback("Good service");

       HotelService hotelService = new HotelServiceImple();
//         hotelService.savedHotel(entity);

//        HotelEntity ref = hotelService.readHotel(entity);
//        System.out.println("Read data from DB:");
//        System.out.println(ref);

        // hotelService.updateHotel(entity);
        // hotelService.deleteHotel(entity);
        // hotelService.getHotelEntityByName("Taj");
        // hotelService.getHotelEntityByDish("Paneer");
        // hotelService.getHotelEntityByPrice(850);
        //4 method
        //hotelService.getHotelEntityByBill(true);
       // hotelService.getHotelEntityByFeedback("Good service");
//        List<HotelEntity> ref =hotelService.getHotelEntityByDish("biryani");
//        for(HotelEntity e:ref)
//        {
//            System.out.println(e);
//        }
//        List<HotelEntity> ref2 =hotelService.getHotelEntityByPrice(200);
//        for(HotelEntity e:ref2)
//        {
//            System.out.println(e);
//        }

        //05-08-25
        //HotelEntity updated=hotelService.updateTheDish("chickenchops","Taj",1);
        //HotelEntity updatedTheName=hotelService.updateTheName("Kashmiri","biryani",2);
        HotelEntity updateByPrice=hotelService.UpdateThePrice(600,"ok",4);





    }
}
