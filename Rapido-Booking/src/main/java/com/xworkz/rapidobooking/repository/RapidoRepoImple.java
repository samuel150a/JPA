package com.xworkz.rapidobooking.repository;

import com.xworkz.rapidobooking.entity.RapidoEntity;

import javax.persistence.*;

public class RapidoRepoImple implements RapidoRepo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public RapidoRepoImple() {
        System.out.println("Created RapidoRepoImple");
    }

    @Override
    public void saveRide(RapidoEntity entity) {
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            System.out.println("Saved: " + entity);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public RapidoEntity readRide(RapidoEntity entity) {
        return em.find(RapidoEntity.class, entity.getID());
    }

    @Override
    public RapidoEntity updateRide(RapidoEntity entity) {
        tx.begin();
        RapidoEntity found = em.find(RapidoEntity.class, entity.getID());
        if (found != null) {
            found.setDropLocation("Marathahalli");
        }
        tx.commit();
        return found;
    }

    @Override
    public RapidoEntity deleteRide(RapidoEntity entity) {
        tx.begin();
        RapidoEntity found = em.find(RapidoEntity.class, entity.getID());
        if (found != null) {
            em.remove(found);
        }
        tx.commit();
        return found;
    }

    @Override
    public RapidoEntity getByVehicleType(String vehicleType) {
        return em.createNamedQuery("vehicleType", RapidoEntity.class).setParameter("vehicleType", vehicleType).getSingleResult();
    }

    @Override
    public RapidoEntity getByMembers(Integer members) {
        return em.createNamedQuery("members", RapidoEntity.class).setParameter("members", members).getSingleResult();
    }

    @Override
    public RapidoEntity getByPickup(String pickupLocation) {
        return em.createNamedQuery("pickupLocation", RapidoEntity.class).setParameter("pickupLocation", pickupLocation).getSingleResult();
    }

    @Override
    public RapidoEntity getByDrop(String dropLocation) {
        return em.createNamedQuery("dropLocation", RapidoEntity.class).setParameter("dropLocation", dropLocation).getSingleResult();
    }

    @Override
    public RapidoEntity getByPayment(Integer payment) {
        return em.createNamedQuery("payment", RapidoEntity.class).setParameter("payment", payment).getSingleResult();
    }
}