package com.xworkz.flightreservation.repository;

import com.xworkz.flightreservation.entity.FlightEntity;

import javax.persistence.*;

public class FlightRepoImple implements FlightRepo {

    public FlightRepoImple() {
        System.out.println("Running in FlightRepoImple constructor");
    }

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

    @Override
    public void savedFlight(FlightEntity entity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            if (entity != null) {
                em.persist(entity);
            }
            tx.commit();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }

    @Override
    public FlightEntity readFlight(FlightEntity entity) {
        FlightEntity result = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            result = em.find(FlightEntity.class, 1);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
        return result;
    }

    @Override
    public FlightEntity updateFlight(FlightEntity entity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            FlightEntity update = em.find(FlightEntity.class, 1);
            if (update != null) {
                update.setDestination("Updated Destination");
            }
            tx.commit();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
        return null;
    }

    @Override
    public FlightEntity deleteFlight(FlightEntity entity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            FlightEntity found = em.find(FlightEntity.class, 1);
            if (found != null) {
                tx = em.getTransaction();
                tx.begin();
                em.remove(found);
                tx.commit();
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
        return entity;
    }

    @Override
    public FlightEntity getFlightEntityByAirlines(String airlines) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            return (FlightEntity) em.createNamedQuery("airlines").setParameter("airlines", airlines).getSingleResult();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }

    @Override
    public FlightEntity getFlightEntityByPersonName(String personName) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            return (FlightEntity) em.createNamedQuery("personName").setParameter("personName", personName).getSingleResult();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }

    @Override
    public FlightEntity getFlightEntityByPrice(Integer price) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            return (FlightEntity) em.createNamedQuery("price").setParameter("price", price).getSingleResult();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }

    @Override
    public FlightEntity getFlightEntityByDestination(String destination) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            return (FlightEntity) em.createNamedQuery("destination").setParameter("destination", destination).getSingleResult();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }

    @Override
    public FlightEntity getFlightEntityByAirport(String airport) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            return (FlightEntity) em.createNamedQuery("airport").setParameter("airport", airport).getSingleResult();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
