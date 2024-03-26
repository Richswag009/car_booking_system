package org.richcodes.User;

import jakarta.persistence.*;
import org.richcodes.Database.Database;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepo implements UserDao{


    @Override
    public List<User> getUsers() {
            try {
                EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
                EntityManager entityManager = entityManagerFactory.createEntityManager();

                EntityTransaction transaction = entityManager.getTransaction();
                transaction.begin();

                String jpql = "SELECT u FROM User u";
                Query query = entityManager.createQuery(jpql, User.class);
                List<User> users = query.getResultList();
                transaction.commit();
                return users;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                // Log the error or throw a custom exception
                return Collections.emptyList(); // Return an empty list or handle the error in your application
            }
    }

    public  void addUser(String username, String email){
        try
        {
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User user = new User(username,email);
            System.out.println(user);
            entityManager.persist(user);
            transaction.commit();
    } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
    }

    }


    @Override
    public Optional<User> getUserByUsername(String name) {
        return Optional.empty();
    }

    public Optional<User> getUserByEmail(String email){
        try{
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            var entityManager =  entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String jpql = "select a from User a where a.email= :matchedValue";
            var query = entityManager.createQuery(jpql,User.class);
            query.setParameter("matchedValue",email) ;
            User user = query.getSingleResult();
            transaction.commit();
           return Optional.ofNullable(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    public boolean emailExist(String email){
        try{
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            var entityManager =  entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String jpql = "select count(a) from User a where a.email= :matchedValue";
            var query = entityManager.createQuery(jpql);
            query.setParameter("matchedValue",email) ;
            long count = (long) query.getSingleResult();
            return (count > 0);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
}
