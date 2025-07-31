package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.service.InteriorService;
import com.xworkz.interiorwork.service.InteriorServiceImple;

import javax.persistence.*;

public class InteriorRepoImple implements InteriorRepo {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public void savedInterior(InteriorEntity entity) {

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            InteriorEntity existing = entityManager.find(InteriorEntity.class, 1);
            if (existing == null) {
                entityManager.persist(entity);
            }

            entityTransaction.commit();


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }


        }


    }

    @Override
    public InteriorEntity readInterior(InteriorEntity readData) {

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            InteriorEntity rd = entityManager.find(InteriorEntity.class, 1);


            entityTransaction.commit();
            InteriorService interiorService = new InteriorServiceImple();
            return interiorService.validation(rd);


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }


        }
        return null;
    }

    @Override
    public InteriorEntity updateInterior(InteriorEntity entity) {
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            InteriorEntity add = entityManager.find(InteriorEntity.class, 5);
            if (add != null) {
                add.setShop("change");
            }
            entityTransaction.commit();
            return null;


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }


        }

        return null;
    }

    @Override
    public InteriorEntity deleteInterior(InteriorEntity entity) {

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            InteriorEntity add = entityManager.find(InteriorEntity.class, 4);
            if (add != null) {
                entityTransaction.begin();
               entityManager.remove(add);
                entityTransaction.commit();

            }

            return null;


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }


        }

        return entity;
    }


}