package com.xworkz.chocolate.runner;

import javax.persistence.*;

public class ChocolateCreate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();


            entityTransaction.commit();


        } catch (PersistenceException e) {
            // System.out.println(e.getMessage());
            e.printStackTrace();
            if(entityTransaction!=null) {
                entityTransaction.rollback();
            }
        } finally {
            if(entityManagerFactory!=null)
            {
                entityManagerFactory.close();
            }
            if(entityManager!=null)
            {
                entityManager.close();
            }



        }
    }
}