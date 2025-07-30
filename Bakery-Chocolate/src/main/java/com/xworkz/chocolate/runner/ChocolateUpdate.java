package com.xworkz.chocolate.runner;


import com.xworkz.chocolate.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager =entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();

        try{
            entityTransaction.begin();
            ChocolateEntity updt=entityManager.find(ChocolateEntity.class,1);
            if(updt!=null)
            {
                updt.setBrand("caremel");
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
