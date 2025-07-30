package com.xworkz.passport.runner;

import com.xworkz.passport.entity.PassportEntity;


import javax.persistence.*;

public class PassportRunner {
    public static void main(String[] args) {
        PassportEntity passportEntity=new PassportEntity();

        passportEntity.setName("Samuel");
        passportEntity.setCountry("canada");
        passportEntity.setSonof("Anthony");
        passportEntity.setValid("1year");

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//connection,load,drivermanager
            EntityManager entityManager = entityManagerFactory.createEntityManager();//(Dml-insert,update,delete) (dql-select)
            EntityTransaction entityTransaction = entityManager.getTransaction();//autocommit

            entityTransaction.begin();
            entityManager.persist(passportEntity);
            entityTransaction.commit();

        }
        catch (PersistenceException e)
        {
            e.printStackTrace();
        }
        finally
        {

        }

    }
}
