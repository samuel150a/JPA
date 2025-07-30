package com.xworkz.footwear.runner;

import com.xworkz.footwear.entity.FootwearEntity;
import com.xworkz.soap.entity.SoapEntity;

import javax.persistence.*;

public class FootwearUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager =entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();


            entityTransaction.begin();
            FootwearEntity updt=entityManager.find(FootwearEntity.class,1);
            if(updt!=null)
            {
                updt.setColor("Grey");
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

