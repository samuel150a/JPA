package com.xworkz.hotelmanagement.repository;

import com.xworkz.hotelmanagement.entity.HotelEntity;

import javax.persistence.*;

public class HotelRepoImple implements HotelRepo {
    public HotelRepoImple() {
        System.out.println("running in the HotelRepoImple constructor");
    }

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public void savedHotel(HotelEntity entity) {
        System.out.println("running in saveHotel method repoimple");
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            if (entity != null) {
                entityManager.persist(entity);
                System.out.println("Data is saved in DataBase");
            } else {
                System.out.println("Entity is null for save operation");
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            System.out.println("Some Exception is occurred");
            System.out.println(e.getMessage());
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity readHotel(HotelEntity entity) {
        System.out.println("running in the readHotel method in repoimple class ");
        HotelEntity result = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            result = entityManager.find(HotelEntity.class, 1);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return result;
    }

    @Override
    public HotelEntity updateHotel(HotelEntity entity) {
        System.out.println("running in updateHotel in repoimple class");
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            HotelEntity update = entityManager.find(HotelEntity.class, 1);
            if (update != null) {
                update.setFeedback("updated feedback");
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return null;
    }

    @Override
    public HotelEntity deleteHotel(HotelEntity entity) {
        System.out.println("running in the deleteHotel method");
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            HotelEntity found = entityManager.find(HotelEntity.class, 1);
            if (found != null) {
                entityTransaction.begin();
                entityManager.remove(found);
                entityTransaction.commit();
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return entity;
    }

    @Override
    public HotelEntity getHotelEntityByName(String name) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("name").setParameter("name", name).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity getHotelEntityByDish(String dish) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("dish").setParameter("dish", dish).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity getHotelEntityByPrice(Integer price) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("price").setParameter("price", price).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity getHotelEntityByBill(boolean bill) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("bill").setParameter("bill", bill).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity getHotelEntityByFeedback(String feedback) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("feedback").setParameter("feedback", feedback).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }
}
