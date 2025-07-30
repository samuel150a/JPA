package com.xworkz.bakery.runner;




import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class BakeryRead {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            entityManager =emf.createEntityManager();
            BakeryEntity ref=entityManager.find(BakeryEntity.class,1);//for reading  data
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
