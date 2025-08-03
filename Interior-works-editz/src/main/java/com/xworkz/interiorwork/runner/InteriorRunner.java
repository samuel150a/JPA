package com.xworkz.interiorwork.runner;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.service.InteriorService;
import com.xworkz.interiorwork.service.InteriorServiceImple;

import javax.persistence.*;

public class InteriorRunner {
    public static void main(String[] args) {
        InteriorEntity interiorEntity1 = new InteriorEntity();

        interiorEntity1.setShop("Design me");
        interiorEntity1.setWood(false);
        interiorEntity1.setPrice(500);
        interiorEntity1.setDoordelivery("no");
        interiorEntity1.setVariety("office");
        interiorEntity1.setType("wood");

        InteriorService interiorService = new InteriorServiceImple();

       // interiorService.savedInterior(interiorEntity1);

        InteriorEntity ref = interiorService.readInterior(interiorEntity1);
       System.out.println(("the list of some readed data from Database"));
       System.out.println(ref);

       //interiorService.updateInterior(interiorEntity1);
        //interiorService.deleteInterior(interiorEntity1);

        //interiorService.getInteriorEntityByName("shop2");
       //interiorService.getInteriorEntityBytype("chigo");
        //interiorService.getInteriorEntityByvariety("hotel");
        //interiorService.getInteriorEntityBywood(false);
        //interiorService.getInteriorEntityByPrice(1250);
        interiorService.getInteriorEntityBydoordelivery("yes but Extra fee");

    }
}



