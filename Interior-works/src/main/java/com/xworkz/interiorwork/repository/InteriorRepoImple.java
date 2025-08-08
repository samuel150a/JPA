package com.xworkz.interiorwork.repository;

import com.xworkz.interiorwork.entity.InteriorEntity;
import com.xworkz.interiorwork.service.InteriorService;
import com.xworkz.interiorwork.service.InteriorServiceImple;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InteriorRepoImple implements InteriorRepo {
    public InteriorRepoImple() {
        System.out.println("running in the InteriorRepoImple constructor");
    }


    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public void savedInterior(InteriorEntity entity) {
        System.out.println("running in saveInterior method repoimple");

        try {
            System.out.println("Connection is established for save operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit


            entityTransaction.begin();
            if (entity != null) {
                entityManager.persist(entity);
                System.out.println("Data is saved in DataBase");
            } else {
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

            System.out.println("Connection is established for read operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            rd = entityManager.find(InteriorEntity.class, 2);
            System.out.println("Data as been readed from database");


        } catch (PersistenceException e) {
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

            System.out.println("Connection is established for update operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityTransaction = entityManager.getTransaction();//rollback,autocommit
            entityTransaction.begin();
            InteriorEntity add = entityManager.find(InteriorEntity.class, 1);
            if (add != null) {
                add.setShop("change");
                System.out.println("Data as been updated in database");
            } else {
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

            } else {
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
        InteriorEntity entityname = null;
        try {

            System.out.println("Connection is established for getInteriorEntityByName operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entityname = (InteriorEntity) entityManager.createNamedQuery("shop").setParameter("shop", shop).getSingleResult();

            System.out.println("Successfully Fetched by name : " + entityname);


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
    public InteriorEntity getInteriorEntityBytype(String type) {
        System.out.println("Running in the getInteriorEntityBytype method in Interior repoImple");
        InteriorEntity entitytype = null;

        try {

            System.out.println("Connection is established for getInteriorEntityBytype operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entitytype = (InteriorEntity) entityManager.createNamedQuery("type").setParameter("type", type).getSingleResult();

            System.out.println("Successfully Fetched by name : " + entitytype);


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

            System.out.println("Connection is established for getInteriorEntityBywood operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            entitywood = (InteriorEntity) entityManager.createNamedQuery("wood").setParameter("wood", wood).getSingleResult();
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

            System.out.println("Connection is established for getInteriorEntityByPrice operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            Query query = entityManager.createNamedQuery("getprice");


            entityprice = (InteriorEntity) query.setParameter("price", price).getSingleResult();


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


        return null;
    }

    @Override
    public InteriorEntity getInteriorEntityBydoordelivery(String doordelivery) {
        System.out.println("Running in the getInteriorEntityBydoordelivery method in Interior repoImple");
        InteriorEntity entitydoordelivery = null;

        try {

            System.out.println("Connection is established for getInteriorEntityBydoordelivery operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            Query query = entityManager.createNamedQuery("doordelivery");
            entitydoordelivery = (InteriorEntity) query.setParameter("doordelivery", doordelivery).getSingleResult();
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


    @Override
    public List<InteriorEntity> fetchAllInterior(InteriorEntity entity) {
        System.out.println("Running in the fetchAllInterior method in Interior repoImple");
        List<InteriorEntity> entityfetchAllInterior = null;

        try {

            System.out.println("Connection is established for fetchAllInterior operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            Query query = entityManager.createNamedQuery("fetchAllInterior");
            entityfetchAllInterior = query.getResultList();

            System.out.println("Successfully Fetched All Data : " + entityfetchAllInterior);


            return entityfetchAllInterior;


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
    public List<InteriorEntity> getBySpecifictype(String entity) {
        System.out.println("Running in getBySpecifictype RepoImle");
        List<InteriorEntity> entitySpecificType = null;
        try {
            System.out.println("Connection is established for getBySpecifictype operation");
            entityManager = entityManagerFactory.createEntityManager();// dml(ins,up,del),DQL(select)
            System.out.println("entity manger is created for Dml operation");
            Query query = entityManager.createNamedQuery("entitySpecificType");
            entitySpecificType = query.getResultList();

            System.out.println("Successfully Fetched All Data : " + entitySpecificType);


            return entitySpecificType;
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
    public List<InteriorEntity> getBYSpecificvariety(String entity) {
        System.out.println("Running in getBYSpecificvariety method in repoImple ");
        List<InteriorEntity> entitySpecificvariety = null;
        try {
            System.out.println("Connection as been established for getBYSpecificvariety");
            entityManager = entityManagerFactory.createEntityManager();
            System.out.println("entity manger is created dml operation");
            Query query = entityManager.createNamedQuery("entitySpecificvariety");
            entitySpecificvariety = query.getResultList();
            return entitySpecificvariety;


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
    public InteriorEntity findByNameByTypedQuery(String n) {
        System.out.println("Running in the findByNameByTypedQuery in repoImple");
        InteriorEntity nameByTypedQuery = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            TypedQuery<InteriorEntity> query = entityManager.createQuery("select a from InteriorEntity a where a.shop=:Storesza", InteriorEntity.class).setParameter("Storesza", n);
            nameByTypedQuery = query.getSingleResult();
            System.out.println(nameByTypedQuery);

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
    public InteriorEntity updateById(String updatedType, String updatedShop, Integer Id) {
        System.out.println("running in the updateById method ");
        InteriorEntity interiorEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();


            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("updateById")
                    .setParameter("type", updatedType).setParameter("shop", updatedShop)
                    .setParameter("ID", Id);
            //System.out.println(query);
            int i = query.executeUpdate();
            System.out.println("updated value" + i);
            interiorEntity = entityManager.find(InteriorEntity.class, Id);

            entityTransaction.commit();
            System.out.println(interiorEntity);


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


        return interiorEntity;


    }

    @Override
    public InteriorEntity updateByPrice(String updatedVariety, Integer Price) {
        System.out.println("Running in the updateByPrice method in repoImlpe");
        InteriorEntity interiorEntityUpdatedPrice = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("updateByPrice")
                    .setParameter("variety", updatedVariety)
                    .setParameter("price", Price);
            int updated = query.executeUpdate();
            interiorEntityUpdatedPrice = entityManager.find(InteriorEntity.class, Price);

            entityTransaction.commit();
            System.out.println(updated);


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
        return interiorEntityUpdatedPrice;

    }

    @Override
    public InteriorEntity updateByShop(Boolean updateWood, String updateShop, Integer Id) {
        System.out.println("running in updateByShop method ");
        InteriorEntity entityupdateByShop = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("updateByShop")
                    .setParameter("wood", updateWood)
                    .setParameter("shop", updateShop)
                    .setParameter("ID", Id);
            int updated = query.executeUpdate();
            entityupdateByShop = entityManager.find(InteriorEntity.class, Id);
            entityTransaction.commit();
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
        return entityupdateByShop;
    }

    @Override
    public List<String> getAllVarietynames() {
        System.out.println("running in the getAllVarietynames method");
        List<String> getAllVarietynamesEntity = null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getAllVarietynames");
            getAllVarietynamesEntity = query.getResultList();

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
        return getAllVarietynamesEntity;
    }

    @Override
    public List<Integer> getAllPrice() {
        System.out.println("running in the getAllPrice method");
        List<Integer> getAllPrice = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getAllPrice");
            getAllPrice = query.getResultList();

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
        return getAllPrice;
    }

    @Override
    public List<Object> getAllWood() {
        System.out.println("running in the getAllWood");
        List<Object> getAllWood = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getAllWood");
            getAllWood = query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();

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
        return getAllWood;
    }

    @Override
    public List<Object[]> FetchTwoColumns() {
        System.out.println("Running in the FetchTwoColumns");
        List<Object[]> FetchTwoColumns = null;

        try {
            FetchTwoColumns = entityManagerFactory.createEntityManager().createNamedQuery("FetchTwoColumns").getResultList();
        }

        catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();

        }
        finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entityManagerFactory is closed");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }


        }
        return FetchTwoColumns;


    }

}

