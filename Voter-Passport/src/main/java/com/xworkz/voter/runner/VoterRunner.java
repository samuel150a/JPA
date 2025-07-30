package com.xworkz.voter.runner;

import com.xworkz.voter.entity.VoterEntity;

import javax.persistence.*;

public class VoterRunner {
    public static void main(String[] args) {
        VoterEntity voterEntity=new VoterEntity();

        voterEntity.setName("Samuel");
        voterEntity.setAge(21);
        voterEntity.setFatherName("Anthony");
        voterEntity.setCitizen("Indian");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try {
             entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
             entityManager = entityManagerFactory.createEntityManager();
             entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(voterEntity);
            entityTransaction.commit();
            System.out.println(voterEntity);

        }
        catch (PersistenceException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
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
