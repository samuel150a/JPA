package com.xworkz.soap.runner;

import com.xworkz.soap.entity.SoapEntity;

import javax.persistence.*;

public class SoapCreate {
    public static void main(String[] args) {
        SoapEntity soapEntity=new SoapEntity();

        soapEntity.setType("Body");
        soapEntity.setCost(65);
        soapEntity.setBrand("Vivel");
        soapEntity.setChemical("no");

                EntityManagerFactory entityManagerFactory=null;
                EntityManager entityManager=null;
                EntityTransaction entityTransaction=null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(soapEntity);
            entityTransaction.commit();
            System.out.println(soapEntity);

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





