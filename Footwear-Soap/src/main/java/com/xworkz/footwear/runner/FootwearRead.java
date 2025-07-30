package com.xworkz.footwear.runner;

import com.xworkz.footwear.entity.FootwearEntity;
import com.xworkz.soap.entity.SoapEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


public class FootwearRead {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            entityManager =emf.createEntityManager();
            FootwearEntity ref=entityManager.find(FootwearEntity.class,1);//for reading  data
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

