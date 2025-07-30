package com.xworkz.collegeevent.runner;

import com.xworkz.collegeevent.entity.CollegeEventEntity;

import javax.persistence.*;

public class CollegeEventCreate {
    public static void main(String[] args) {
        CollegeEventEntity collegeEventEntity=new CollegeEventEntity();

        collegeEventEntity.setCollegeName("kvg");
        collegeEventEntity.setPrincipal("suresh");
        collegeEventEntity.setStudentName("prasad");
        collegeEventEntity.setCourse("be");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(collegeEventEntity);
            entityTransaction.commit();
            System.out.println(collegeEventEntity);

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





