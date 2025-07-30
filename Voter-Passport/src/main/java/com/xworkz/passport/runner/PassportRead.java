package com.xworkz.passport.runner;

import com.xworkz.passport.entity.PassportEntity;
import com.xworkz.voter.entity.VoterEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class PassportRead {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            entityManager =emf.createEntityManager();
            PassportEntity ref=entityManager.find(PassportEntity.class,1);//for reading  data
            System.out.println(ref);

        }
        catch(PersistenceException e)
        {
            e.printStackTrace();
            //System.out.println(e.getMessage());

        }
        finally{
            if(emf!=null)
            {
                emf.close();
                System.out.println("emf is closed");

            }
            if(entityManager!=null)
            {
                entityManager.close();
                System.out.println("entityManger is closed");
            }
        }
    }
}
