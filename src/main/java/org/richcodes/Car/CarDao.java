package org.richcodes.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.richcodes.Brand;
import org.richcodes.Database.Database;

import java.util.*;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("promise", Brand.FORD,"34HYD32",false),
                new Car("paul",Brand.TESLA,"B4HGK30",true),
                new Car("riches",Brand.BMW,"P4HYD32",false),
                new Car("poto",Brand.TESLA,"M7YD32",true),
                new Car("gbenga",Brand.FORD,"O0RHYD32",false),
                new Car("elisha",Brand.TOYOTA,"L9HYD32",false),
                new Car("elisha",Brand.TESLA,"L9HYD32",true),
        };
    }

    public Car[] getCars() {
        return cars;
    }
    public Car getCarByRegNo(String name){
        for (var car : cars){
            if(car.getRegNO().equalsIgnoreCase(name)){
                System.out.println("found Car with a regNo: " + name);
                return car;
            }
        }
        System.out.println("Car not found");
        return null;
    }


// without streams
    public List<Car> getElectricCars() {
        List<Car> electricCars = new ArrayList<>();
        for (var car : getCars()) {
            if (car.isElectric() && !car.getCarIsBooked()) {
                electricCars.add(car);
            }
        }
        if (electricCars.isEmpty()) {
            System.out.println("No Electric cars  available:");
        }
        return electricCars;
    }

    //Using streams
    public List<Car> getAllElectricCars(){
        return Arrays.stream(getCars()).filter(Car::isElectric).toList();
    }


    public List<Car> availableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (var car : getCars()) {
            if (!car.getCarIsBooked()) {
                availableCars.add(car);
            }
        }
        if (availableCars.isEmpty()) {
            System.out.println("No cars is available for booking: ");
        }
        return availableCars;
    }


//    using stream
    public List<Car> availableCarsUsingStreams(){
        return Arrays.stream(getCars()).filter(s-> !s.getCarIsBooked()).toList();
    }

    /*
    belows are function for database operations
     */

    public List<Car> fetchCars(){
        try {
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String jpql = "SELECT u FROM Car u";
            var query = entityManager.createQuery(jpql, Car.class);
            List<Car> users = query.getResultList();
            transaction.commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            // Log the error or throw a custom exception
            return Collections.emptyList(); // Return an empty list or handle the error in your application
        }
    }

    public  void addCar(String driverName, Brand brand, String carRegNo,boolean isElectric){
        try
        {
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Car car = new Car(driverName,brand,carRegNo,isElectric);
            System.out.println(car);
            entityManager.persist(car);
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public Optional<Car> fetchCarByRegNo(String carRegNo){
        try{
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            var transaction = entityManager.getTransaction();
            transaction.begin();
            String jpql="select a from Car a where a.regNO = :matchedValue";
            var query = entityManager.createQuery(jpql, Car.class);
            query.setParameter("matchedValue",carRegNo) ;
            Car car = query.getSingleResult();
            transaction.commit();
            return Optional.ofNullable(car);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return Optional.empty();

        }
    }

    public boolean carRegNoExist(String carRegNo){
        try{
            EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
            var entityManager =  entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String jpql = "select count(a) from Car a where a.regNO= :matchedValue";
            var query = entityManager.createQuery(jpql);
            query.setParameter("matchedValue",carRegNo) ;
            long count = (long) query.getSingleResult();
            return (count > 0);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
}