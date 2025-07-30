package com.xworkz.soap.runner;

import com.xworkz.soap.entity.SoapEntity;

import javax.persistence.*;

public class SoapUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager =entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            SoapEntity updt=entityManager.find(SoapEntity.class,1);
            if(updt!=null)
            {
                updt.setType("vesselcleaner");
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

