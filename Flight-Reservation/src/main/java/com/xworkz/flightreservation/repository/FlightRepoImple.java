package com.xworkz.flightreservation.repository;

import com.xworkz.flightreservation.entity.FlightEntity;

import javax.persistence.*;
import java.util.List;

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
    public FlightEntity getFlightEntityByDestination(String destination) {
        System.out.println("running in the getFlightEntityByDestination");
        FlightEntity FlightEntityByDestination = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            System.out.println("connection created");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getDestination");
            FlightEntityByDestination = (FlightEntity) query.setParameter("destination", destination).getSingleResult();
            System.out.println(FlightEntityByDestination);
            return FlightEntityByDestination;
        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
        return FlightEntityByDestination;
    }

    @Override
    public FlightEntity getFlightEntityByAirport(String airport) {
        System.out.println("Running in the getFlightEntityByAirport");
        FlightEntity flightEntityByAirport = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getAirport");
            flightEntityByAirport = (FlightEntity) query.setParameter("airport", airport).getSingleResult();
            System.out.println(flightEntityByAirport);
            return flightEntityByAirport;
        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }


        return flightEntityByAirport;
    }

    @Override
    public List<FlightEntity> getFlightEntityByPrice(Integer price) {
        System.out.println("running in getFlightEntityByPrice ");
        List<FlightEntity> flightEntityByPrice=null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getPrice");
            flightEntityByPrice = query.getResultList();
            return flightEntityByPrice;
        }
            catch (PersistenceException e) {
                System.out.println("Exception has been found");
                System.out.println(e.getMessage());
                //e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
        return flightEntityByPrice;
    }

}