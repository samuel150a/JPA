package com.xworkz.collegeevent.runner;


import com.xworkz.collegeevent.entity.CollegeEventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class CollegeEventRead {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            entityManager =emf.createEntityManager();
           CollegeEventEntity ref=entityManager.find(CollegeEventEntity.class,1);//for reading  data
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

