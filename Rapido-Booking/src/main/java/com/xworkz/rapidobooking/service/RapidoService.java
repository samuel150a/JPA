package com.xworkz.rapidobooking.service;

import com.xworkz.rapidobooking.entity.RapidoEntity;

public interface RapidoService {
    void saveRide(RapidoEntity entity);
    RapidoEntity readRide(RapidoEntity entity);
    RapidoEntity updateRide(RapidoEntity entity);
    RapidoEntity deleteRide(RapidoEntity entity);
    RapidoEntity getByVehicleType(String vehicleType);
    RapidoEntity getByMembers(Integer members);
    RapidoEntity getByPickup(String pickupLocation);
    RapidoEntity getByDrop(String dropLocation);
    RapidoEntity getByPayment(Integer payment);
}