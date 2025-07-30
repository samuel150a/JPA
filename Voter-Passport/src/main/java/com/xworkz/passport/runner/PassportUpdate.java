package com.xworkz.passport.runner;

import com.xworkz.passport.entity.PassportEntity;

import javax.persistence.*;

public class PassportUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
          try{
        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager =entityManagerFactory.createEntityManager();
        EntityTransaction et=entityManager.getTransaction();

        et.begin();
        PassportEntity updt=entityManager.find(PassportEntity.class,1);
              if(updt!=null) {
                  updt.setName("roshan");
                  System.out.println(updt);
                  et.commit();
              }
    }
          catch(PersistenceException e)
          {
              System.out.println(e.getMessage());
          }


          finally {
              if (entityManagerFactory != null) {
                  entityManagerFactory.close();
              } else {
                  System.out.println("entitymanagerFactory not closed");


              }

              if (entityManager != null) {
                  entityManager.close();
              } else {
                  System.out.println(" entitymanager not closed");
              }

          }
        }
}
