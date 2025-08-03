package com.xworkz.rapidobooking.service;

import com.xworkz.rapidobooking.entity.RapidoEntity;
import com.xworkz.rapidobooking.repository.RapidoRepo;
import com.xworkz.rapidobooking.repository.RapidoRepoImple;

public class RapidoServiceImple implements RapidoService {

    RapidoRepo repo = new RapidoRepoImple();

    @Override
    public void saveRide(RapidoEntity entity) {
        if (entity != null && entity.getPayment() < 500) {
            repo.saveRide(entity);
        }
    }

    @Override
    public RapidoEntity readRide(RapidoEntity entity) {
        return repo.readRide(entity);
    }

    @Override
    public RapidoEntity updateRide(RapidoEntity entity) {
        return repo.updateRide(entity);
    }

    @Override
    public RapidoEntity deleteRide(RapidoEntity entity) {
        return repo.deleteRide(entity);
    }

    @Override
    public RapidoEntity getByVehicleType(String vehicleType) {
        return repo.getByVehicleType(vehicleType);
    }

    @Override
    public RapidoEntity getByMembers(Integer members) {
        return repo.getByMembers(members);
    }

    @Override
    public RapidoEntity getByPickup(String pickupLocation) {
        return repo.getByPickup(pickupLocation);
    }

    @Override
    public RapidoEntity getByDrop(String dropLocation) {
        return repo.getByDrop(dropLocation);
    }

    @Override
    public RapidoEntity getByPayment(Integer payment) {
        return repo.getByPayment(payment);
    }
}