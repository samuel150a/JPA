package com.xworkz.rapidobooking.runner;

import com.xworkz.rapidobooking.entity.RapidoEntity;
import com.xworkz.rapidobooking.service.RapidoService;
import com.xworkz.rapidobooking.service.RapidoServiceImple;

public class RapidoRunner {
    public static void main(String[] args) {
        RapidoEntity entity = new RapidoEntity();
        entity.setVehicleType("Bike");
        entity.setMembers(1);
        entity.setPickupLocation("BTM");
        entity.setDropLocation("Electronic City");
        entity.setPayment(120);

        RapidoService service = new RapidoServiceImple();

        service.saveRide(entity);

//        RapidoEntity readEntity = service.readRide(entity);
//        System.out.println("Read Entity: " + readEntity);
//
//
//        RapidoEntity updated = service.updateRide(entity);
//        System.out.println("Updated: " + updated);
//
//        RapidoEntity deleted = service.deleteRide(entity);
//        System.out.println("Deleted: " + deleted);
//
//        System.out.println("Get by Pickup: " + service.getByPickup("BTM"));
//        System.out.println("Get by Members: " + service.getByMembers(1));
//        System.out.println("Get by DropLocation "+service.getByDrop("Electronic City"));
//
//        System.out.println("Get by Payment"+service.getByPayment(120));
//        System.out.println("Get By VechicleType"+service.getByVehicleType("Bike"));
    }
}
