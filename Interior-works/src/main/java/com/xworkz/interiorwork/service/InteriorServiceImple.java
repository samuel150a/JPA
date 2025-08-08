package com.xworkz.interiorwork.service;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.repository.InteriorRepo;
import com.xworkz.interiorwork.repository.InteriorRepoImple;
import com.xworkz.interiorwork.runner.InteriorRunner;

import java.util.Collections;
import java.util.List;

import static sun.plugin2.liveconnect.ArgumentHelper.validate;

public class InteriorServiceImple implements InteriorService{
    InteriorRepo interiorRepo = new InteriorRepoImple();


    public InteriorServiceImple()
    {

        System.out.println("running in InteriorServiceImple constructor");
    }

    @Override
    public InteriorEntity validation(InteriorEntity en) {
        System.out.println("running in the validation method in InteriorServiceImple class ");

        if (en != null) {
            System.out.println("Data is valid");

            if (en.getVariety()!=null) {
                System.out.println("Variety is valid");
            } else {
                System.out.println("vareity is null");

            }

            if (en.getPrice() < 4000) {
                System.out.println("Perfect cost");
            } else {
                System.out.println("not available");
                return null;
            }

            interiorRepo.savedInterior(en);
        } else {
            System.out.println("Data is not null");
            return null;
        }

        return null;

    }
    @Override
    public void savedInterior(InteriorEntity entity) {
        System.out.println("Running in savedInterior in serviceimple");
        validation( entity);

    }

    @Override
    public InteriorEntity readInterior(InteriorEntity entity) {
        System.out.println("Running in readInterior in serviceimple");

        return interiorRepo.readInterior(entity);

    }

    @Override
    public InteriorEntity updateInterior(InteriorEntity entity) {
        System.out.println("Running in updateInterior in serviceimple");
        return interiorRepo.updateInterior( entity);
    }

    @Override
    public InteriorEntity deleteInterior(InteriorEntity entity) {
        System.out.println("Running in deleteInterior in serviceimple");
        return interiorRepo.deleteInterior(entity);
    }

    @Override
    public InteriorEntity getInteriorEntityByName(String shop) {
        return interiorRepo.getInteriorEntityByName(shop);
    }

    @Override
    public InteriorEntity getInteriorEntityBytype(String type)
    {
        return interiorRepo.getInteriorEntityBytype(type);
    }

    @Override
    public InteriorEntity getInteriorEntityByvariety(String variety) {

        return interiorRepo.getInteriorEntityByvariety(variety);
    }

    @Override
    public InteriorEntity getInteriorEntityBywood(boolean wood) {
        return interiorRepo.getInteriorEntityBywood(wood);
    }

    @Override
    public InteriorEntity getInteriorEntityByPrice(Integer price) {
        return interiorRepo.getInteriorEntityByPrice(price);
    }

    @Override
    public InteriorEntity getInteriorEntityBydoordelivery(String doordelivery) {
        return interiorRepo.getInteriorEntityBydoordelivery(doordelivery);
    }

    @Override
    public List<InteriorEntity> fetchAllInterior(InteriorEntity entity) {
        return interiorRepo.fetchAllInterior(entity);
    }

    @Override
    public List<InteriorEntity> getBySpecifictype(String entity) {
        return interiorRepo.getBySpecifictype(entity);
    }

    @Override
    public List<InteriorEntity> getBYSpecificvariety(String entity) {
        return interiorRepo.getBYSpecificvariety(entity);
    }
}