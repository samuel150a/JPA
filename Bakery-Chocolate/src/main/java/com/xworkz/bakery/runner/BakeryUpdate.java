package com.xworkz.bakery.runner;


import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager =entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();

        try{
            entityTransaction.begin();
            BakeryEntity updt=entityManager.find(BakeryEntity.class,1);
            if(updt!=null)
            {
                updt.setItem("water");
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
