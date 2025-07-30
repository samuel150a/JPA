package com.xworkz.petadopt.runner;

import com.xworkz.collegeevent.entity.CollegeEventEntity;
import com.xworkz.petadopt.entity.PetAdoptEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class PetAdoptEntityRead {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            entityManager =emf.createEntityManager();
            PetAdoptEntity ref=entityManager.find(PetAdoptEntity.class,1);//for reading  data
            System.out.println(ref);

        }
        catch(PersistenceException e)
        {
            e.printStackTrace();


        }
        finally{
            if(emf!=null)
            {
                emf.close();

            }
            if(entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
}

