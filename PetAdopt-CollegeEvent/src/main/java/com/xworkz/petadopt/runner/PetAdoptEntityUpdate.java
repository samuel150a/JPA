package com.xworkz.petadopt.runner;

import com.xworkz.collegeevent.entity.CollegeEventEntity;
import com.xworkz.petadopt.entity.PetAdoptEntity;

import javax.persistence.*;

public class PetAdoptEntityUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();


            entityTransaction.begin();
            PetAdoptEntity updt=entityManager.find(PetAdoptEntity.class,1);
            if(updt!=null)
            {
                updt.setBreed("sizu");
                System.out.println(updt);
            }

            entityTransaction.commit();
        }
        catch(PersistenceException e){
            if(entityTransaction!=null)
            {
                entityTransaction.rollback();
            }
        }
        finally{
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

