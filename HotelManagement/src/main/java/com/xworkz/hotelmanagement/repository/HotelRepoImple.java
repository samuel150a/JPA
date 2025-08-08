package com.xworkz.hotelmanagement.repository;

import com.xworkz.hotelmanagement.entity.HotelEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class HotelRepoImple implements HotelRepo {
    public HotelRepoImple() {
        System.out.println("running in the HotelRepoImple constructor");
    }

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public void savedHotel(HotelEntity entity) {
        System.out.println("running in saveHotel method repoimple");
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            if (entity != null) {
                entityManager.persist(entity);
                System.out.println("Data is saved in DataBase");
            } else {
                System.out.println("Entity is null for save operation");
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            System.out.println("Some Exception is occurred");
            System.out.println(e.getMessage());
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public HotelEntity readHotel(HotelEntity entity) {
        System.out.println("running in the readHotel method in repoimple class ");
        HotelEntity result = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            result = entityManager.find(HotelEntity.class, 1);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return result;
    }

    @Override
    public HotelEntity updateHotel(HotelEntity entity) {
        System.out.println("running in updateHotel in repoimple class");
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            HotelEntity update = entityManager.find(HotelEntity.class, 1);
            if (update != null) {
                update.setFeedback("updated feedback");
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return null;
    }

    @Override
    public HotelEntity deleteHotel(HotelEntity entity) {
        System.out.println("running in the deleteHotel method");
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            HotelEntity found = entityManager.find(HotelEntity.class, 1);
            if (found != null) {
                entityTransaction.begin();
                entityManager.remove(found);
                entityTransaction.commit();
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return entity;
    }

    @Override
    public HotelEntity getHotelEntityByName(String name) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return (HotelEntity) entityManager.createNamedQuery("name").setParameter("name", name).getSingleResult();
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
    }




    @Override
    public HotelEntity getHotelEntityByBill(boolean bill) {
        HotelEntity hotelEntityByBill = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getbill");
            hotelEntityByBill = (HotelEntity) query.setParameter("bill", bill).getSingleResult();
            System.out.println("fetched by hotelEntityByBill false " + hotelEntityByBill);
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
    public HotelEntity getHotelEntityByFeedback(String feedback) {
        HotelEntity entityByFeedback = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getfeedback");
            entityByFeedback = (HotelEntity) query.setParameter("feedback", feedback).getSingleResult();
            System.out.println("the fetched value getHotelEntityByFeedback " + entityByFeedback);

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
    public List<HotelEntity> getHotelEntityByDish(String dish) {
        List<HotelEntity> hotelEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNamedQuery("getDish");
            hotelEntity = query.getResultList();
            return hotelEntity;
        } catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }
        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return hotelEntity;
    }

    @Override
    public List<HotelEntity> getHotelEntityByPrice(Integer price) {
        List<HotelEntity> hotelEntityByPrices=null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("getPrice");
            hotelEntityByPrices = query.getResultList();
            return hotelEntityByPrices;
        }
            catch (PersistenceException e) {
                System.out.println("Exception has been found");
                System.out.println(e.getMessage());
                //e.printStackTrace();
                if (entityTransaction != null) {
                    entityTransaction.rollback();
                    System.out.println("Due to Exception rollback is done");
                }

        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return hotelEntityByPrices;
    }

    @Override
    public HotelEntity updateTheDish(String updatedish, String name, Integer id) {
        System.out.println("running in the  updateTheDish");
        HotelEntity entityupdateTheDish=null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("updateTheDish")
                    .setParameter("dish", updatedish)
                    .setParameter("name", name)
                    .setParameter("ID", id);
            int updated = query.executeUpdate();
            entityupdateTheDish = entityManager.find(HotelEntity.class, id);
            System.out.println(entityupdateTheDish);
            entityTransaction.commit();
        }
        catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }

        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return null;
    }

    @Override
    public HotelEntity updateTheName(String updatedName, String dish, Integer id) {
        System.out.println("Running in the updateTheName method");
        HotelEntity entityupdateTheName=null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("updateTheName")
                    .setParameter("name", updatedName)
                    .setParameter("dish", dish)
                    .setParameter("ID", id);
            int update = query.executeUpdate();
            entityupdateTheName = entityManager.find(HotelEntity.class, id);
            entityTransaction.commit();
            System.out.println(entityupdateTheName);
        }

       catch (PersistenceException e) {
                System.out.println("Exception has been found");
                System.out.println(e.getMessage());
                //e.printStackTrace();
                if (entityTransaction != null) {
                    entityTransaction.rollback();
                    System.out.println("Due to Exception rollback is done");
                }

            } finally {
                if (entityManagerFactory != null) entityManagerFactory.close();
                if (entityManager != null) entityManager.close();
            }
            return null;
    }

    @Override
    public HotelEntity UpdateThePrice(Integer updatedPrice, String feedback, Integer id) {
        System.out.println("running in the UpdateThePrice ");
        HotelEntity entityUpdateThePrice=null;
        try{
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
            Query query=entityManager.createNamedQuery("UpdateThePrice")
                    .setParameter("price",updatedPrice)
                    .setParameter("feedback",feedback)
                    .setParameter("ID",id);

            int updated=query.executeUpdate();
            entityUpdateThePrice=entityManager.find(HotelEntity.class,id);
            entityTransaction.commit();
            System.out.println(entityUpdateThePrice);

        }
        catch (PersistenceException e) {
            System.out.println("Exception has been found");
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("Due to Exception rollback is done");
            }

        } finally {
            if (entityManagerFactory != null) entityManagerFactory.close();
            if (entityManager != null) entityManager.close();
        }
        return null;
    }
}
