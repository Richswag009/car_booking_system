package org.richcodes.CarBooking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.richcodes.Car.CarService;
import org.richcodes.Database.Database;
import org.richcodes.User.UserService;

import java.util.List;

public class CarBookingDao {
    public static final UserService userService = new UserService();
    public static final CarService carService = new CarService();



    public  void addBooking(String email, String carRegNO){
            try
            {
                EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
                EntityManager entityManager = entityManagerFactory.createEntityManager();

                EntityTransaction transaction = entityManager.getTransaction();
                transaction.begin();
                var user = userService.findUserByEmail(email);
                var car = carService.findCarByRegNo(carRegNO);
                if (user != null && car != null && !car.getCarIsBooked()) {
                    CarBooking carBooking = new CarBooking(user, car);
                    System.out.println(carBooking);
                    entityManager.persist(carBooking);
                    car.setBooked(true);
                    entityManager.merge(car);
                    transaction.commit();
                }else{
                    System.out.println("==========");
                    System.out.println(" --> user not found, or car not found , or car is already booked");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    public List<CarBooking> getAllBookings() {
        EntityManagerFactory entityManagerFactory = Database.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        var query = entityManager.createQuery("SELECT b FROM CarBooking b", CarBooking.class);
        List<CarBooking> bookings = query.getResultList();
        transaction.commit();
        return bookings;
    }

    public List<CarBooking> getAUserBookings(String email) {
        var user = userService.findUserByEmail(email);
        return getAllBookings().stream().filter(carBooking1 ->
                        carBooking1.getUser().equals(user))
                .toList();

    }




}
