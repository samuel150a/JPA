package com.xworkz.interiorwork.runner;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.repository.InteriorRepo;
import com.xworkz.interiorwork.repository.InteriorRepoImple;
import com.xworkz.interiorwork.service.InteriorService;
import com.xworkz.interiorwork.service.InteriorServiceImple;

import javax.persistence.*;

public class InteriorRunner {
    public static void main(String[] args) {
        InteriorEntity interiorEntity1 = new InteriorEntity();
        interiorEntity1.setID(1);
        interiorEntity1.setShop("bakes");
        interiorEntity1.setWood(false);
        interiorEntity1.setPrice(1000);
        interiorEntity1.setDoordelivery("no");
        interiorEntity1.setVariety("office");
        interiorEntity1.setType("wood");

        

        InteriorService interiorService = new InteriorServiceImple();
        interiorService.validation(interiorEntity1);

        InteriorRepo interiorUpdate = new InteriorRepoImple();
        interiorUpdate.updateInterior(interiorEntity1);

        InteriorRepo interiorDelete= new InteriorRepoImple();
        interiorDelete.deleteInterior(interiorEntity1);









    }


    public InteriorEntity readInterior(InteriorEntity display)
    {
        System.out.println("Read operation done displaying in the console:");
        System.out.println(display);


        return display;

    }
}


