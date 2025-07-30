package com.xworkz.voter.runner;

import com.xworkz.voter.entity.VoterEntity;

import javax.persistence.*;

public class VoterUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
         entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
         entityManager =entityManagerFactory.createEntityManager();
         entityTransaction=entityManager.getTransaction();


             entityTransaction.begin();
             VoterEntity updt=entityManager.find(VoterEntity.class,1);
             if(updt!=null)
             {
                 updt.setCitizen("Australia");
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
