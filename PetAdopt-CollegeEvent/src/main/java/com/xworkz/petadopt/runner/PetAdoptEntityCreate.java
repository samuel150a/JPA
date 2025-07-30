package com.xworkz.petadopt.runner;

import com.xworkz.collegeevent.entity.CollegeEventEntity;
import com.xworkz.petadopt.entity.PetAdoptEntity;

import javax.persistence.*;

public class PetAdoptEntityCreate {
    public static void main(String[] args) {
        PetAdoptEntity petAdoptEntity=new PetAdoptEntity();

        petAdoptEntity.setPetName("tommy");
        petAdoptEntity.setBreed("germen");
        petAdoptEntity.setColor("brown");
        petAdoptEntity.setType("male");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(petAdoptEntity);
            entityTransaction.commit();
            System.out.println(petAdoptEntity);

        }
        catch (PersistenceException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            if(entityTransaction!=null) {
                entityTransaction.rollback();
            }
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





