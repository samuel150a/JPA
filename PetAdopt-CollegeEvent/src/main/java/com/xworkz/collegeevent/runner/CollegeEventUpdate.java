package com.xworkz.collegeevent.runner;


import com.xworkz.collegeevent.entity.CollegeEventEntity;

import javax.persistence.*;

public class CollegeEventUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();


            entityTransaction.begin();
            CollegeEventEntity updt=entityManager.find(CollegeEventEntity.class,1);
            if(updt!=null)
            {
                updt.setCourse("mtech");
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

