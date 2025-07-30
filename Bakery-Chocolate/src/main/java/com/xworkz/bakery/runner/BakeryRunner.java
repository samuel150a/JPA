package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryRunner {
    public static void main(String[] args) {

        BakeryEntity bakeryEntity=new BakeryEntity();

        bakeryEntity.setName("CakesOwen");
        bakeryEntity.setItem("Bread");
        bakeryEntity.setPrice(60);
        bakeryEntity.setBill("paid");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try {
             entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
             entityManager = entityManagerFactory.createEntityManager();
             entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(bakeryEntity);
            entityTransaction.commit();
            System.out.println(bakeryEntity);

        }
        catch (PersistenceException e)
        {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally
        {
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
