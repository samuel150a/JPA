package com.xworkz.footwear.runner;

import com.xworkz.footwear.entity.FootwearEntity;
import com.xworkz.soap.entity.SoapEntity;

import javax.persistence.*;

public class FootwearCreate {
    public static void main(String[] args) {
        FootwearEntity footwearEntity=new FootwearEntity();

        footwearEntity.setPerson("Gens");
        footwearEntity.setColor("black");
        footwearEntity.setOwner("raj");
        footwearEntity.setLeather("no");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(footwearEntity);
            entityTransaction.commit();
            System.out.println(footwearEntity);

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





