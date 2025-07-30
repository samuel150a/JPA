package com.xworkz.chocolate.runner;

import com.xworkz.bakery.entity.BakeryEntity;
import com.xworkz.chocolate.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateRunner {
    public static void main(String[] args) {
        ChocolateEntity chocolateEntity=new ChocolateEntity();
        chocolateEntity.setName("dairymilk");
        chocolateEntity.setBrand("parlae");
        chocolateEntity.setCalories(60);
        chocolateEntity.setShop("Vinu");
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try {
             entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
             entityManager = entityManagerFactory.createEntityManager();
             entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(chocolateEntity);
            entityTransaction.commit();

        }
        catch (PersistenceException e)
        {
            e.printStackTrace();
        }
        finally {
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