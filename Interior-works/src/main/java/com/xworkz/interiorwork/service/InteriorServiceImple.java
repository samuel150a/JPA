package com.xworkz.interiorwork.service;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.repository.InteriorRepo;
import com.xworkz.interiorwork.repository.InteriorRepoImple;
import com.xworkz.interiorwork.runner.InteriorRunner;

public class InteriorServiceImple implements InteriorService{

    @Override
    public InteriorEntity validation(InteriorEntity en) {
        if (en != null) {
            System.out.println("data is valid");
        } else {
            System.out.println("data is not valid");

        }
        if ("wood".equals(en.getVariety()))
        {
            System.out.println("Valid");
        }

        if (en.getPrice() < 4000) {
            System.out.println("Perfect cost");
        } else {
            System.out.println("not available");
        }


        InteriorRepo interiorRepo = new InteriorRepoImple();
        interiorRepo.savedInterior(en);
if(en!=null) {
    InteriorRunner interiorRunner = new InteriorRunner();
    return interiorRunner.readInterior(en);

}

return en;

    }
}
