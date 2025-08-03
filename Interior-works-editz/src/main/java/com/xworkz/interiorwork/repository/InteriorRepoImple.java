package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.service.InteriorService;
import com.xworkz.interiorwork.service.InteriorServiceImple;

import javax.persistence.*;

public class InteriorRepoImple implements InteriorRepo {
public InteriorRepoImple()
{
    System.out.println("running in the InteriorRepoImple constructor");
}

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public void savedInterior(InteriorEntity entity) {
        System.out.println("running in saveInterior method repoimple");

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for save operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit


            entityTransaction.begin();
            if (entity != null) {
                entityManager.persist(entity);
                System.out.println("Data is saved in DataBase");
            }
            else {
                System.out.println("Entity is null for save operation");
            }
            entityTransaction.commit();


        } catch (PersistenceException e) {
            System.out.println("Some Exception is occured");
            System.out.println(e.getMessage());

            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to exception rollback is done ");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");

            }


        }


    }




    @Override
    public InteriorEntity readInterior(InteriorEntity entity) {
        System.out.println("running in the readInterior method in repoimple class ");
        InteriorEntity rd = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for read operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
             rd = entityManager.find(InteriorEntity.class, 2);
            System.out.println("Data as been readed from database");




        }

        catch (PersistenceException e) {
            System.out.println("Some Exception as been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("RollBack is done due to some Exception ");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory closed for read operation");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager closed for read operation");
            }

        }
        return rd;

    }

    @Override
    public InteriorEntity updateInterior(InteriorEntity entity) {
        System.out.println("running in updateInterior in repoimple class");
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for update operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            InteriorEntity add = entityManager.find(InteriorEntity.class, 1);
            if (add != null) {
                add.setShop("change");
                System.out.println("Data as been updated in database");
            }
            else {
                System.out.println("given entity is null");
            }
            entityTransaction.commit();

            return null;


        } catch (PersistenceException e) {
            System.out.println("some Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception Rollback is done ");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory as been closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager as been closed");
            }


        }

        return null;
    }

    @Override
    public InteriorEntity deleteInterior(InteriorEntity entity) {
        System.out.println("running in the deleteInterior method updateInterior");
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for delete operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            InteriorEntity add = entityManager.find(InteriorEntity.class, 1);
            if (add != null) {
                entityTransaction.begin();
                entityManager.remove(add);
                entityTransaction.commit();
                System.out.println("Successfully deleted");

            }
            else{
                System.out.println("given entity is null");
            }

            return null;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }

        return entity;
    }

    @Override
    public InteriorEntity getInteriorEntityByName(String shop) {
        System.out.println("Running in the getInteriorEntityByName method in Interior repoImple");
       InteriorEntity entityname =null;
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for getInteriorEntityByName operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityname=(InteriorEntity) entityManager.createNamedQuery("shop").setParameter("shop",shop).getSingleResult();

                System.out.println("Successfully Fetched by name : "+entityname);




            return entityname;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }


        return null;
    }

    @Override
    public InteriorEntity getInteriorEntityBytype(String type)
    {
        System.out.println("Running in the getInteriorEntityBytype method in Interior repoImple");
    InteriorEntity entitytype =null;

        try {

        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
        System.out.println("Connection is established for getInteriorEntityBytype operation");
        entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
        System.out.println("entity manger is created for Dml operation");
            entitytype=(InteriorEntity) entityManager.createNamedQuery("type").setParameter("type",type).getSingleResult();

        System.out.println("Successfully Fetched by name : "+entitytype);




        return entitytype;


    } catch (PersistenceException e) {
        System.out.println("Exception has been found");
        System.out.println(e.getMessage());
        //e.printStackTrace();
        if (entityTransaction != null) {
            entityTransaction.rollback();
            System.out.println("Due to Exception rollback is done");
        }
    } finally {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            System.out.println("entityManagerFactory is closed");
        }
        if (entityManager != null) {
            entityManager.close();
            System.out.println("entityManager is closed");
        }


    }


        return null;
}

    @Override
    public InteriorEntity getInteriorEntityByvariety(String variety) {
        System.out.println("Running in the getInteriorEntityByvariety method in Interior repoImple");
        InteriorEntity entityvariety = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for getInteriorEntityByvariety operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityvariety = (InteriorEntity) entityManager.createNamedQuery("variety").setParameter("variety", variety).getSingleResult();
            System.out.println("Successfully Fetched by name : " + entityvariety);


            return entityvariety;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }


        return null;

    }

    @Override
    public InteriorEntity getInteriorEntityBywood(boolean wood) {
        System.out.println("Running in the getInteriorEntityBywood method in Interior repoImple");
        InteriorEntity entitywood = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for getInteriorEntityBywood operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entitywood=(InteriorEntity) entityManager.createNamedQuery("wood").setParameter("wood",wood).getSingleResult();
            System.out.println("Successfully Fetched by name : " + entitywood);


            return entitywood;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }


        return null;
    }

    @Override
    public InteriorEntity getInteriorEntityByPrice(Integer price) {
        System.out.println("Running in the getInteriorEntityByPrice method in Interior repoImple");
        InteriorEntity entityprice = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for getInteriorEntityByPrice operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityprice=(InteriorEntity) entityManager.createNamedQuery("price").setParameter("price",price).getSingleResult();
            System.out.println("Successfully Fetched by name : " + entityprice);


            return entityprice;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }


        return null;
    }

    @Override
    public InteriorEntity getInteriorEntityBydoordelivery(String doordelivery) {
        System.out.println("Running in the getInteriorEntityBydoordelivery method in Interior repoImple");
        InteriorEntity entitydoordelivery= null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,connection
            System.out.println("Connection is established for getInteriorEntityBydoordelivery operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entitydoordelivery=(InteriorEntity) entityManager.createNamedQuery("doordelivery").setParameter("doordelivery",doordelivery).getSingleResult();
            System.out.println("Successfully Fetched by name : " + entitydoordelivery);


            return entitydoordelivery;


        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }


        return null;
    }
}