package org.richcodes.Booking;

import org.richcodes.Car.Car;
import org.richcodes.CarBooking.CarBooking;
import org.richcodes.User.User;

import java.util.ArrayList;
import java.util.List;

public class BookingDao {

    private final List<CarBooking> carBooking;
    public  BookingDao(int capacity){
        carBooking = new ArrayList<>();
    }

    public void addBooking(User user, Car car){
        CarBooking carBook= new CarBooking(user, car);
        carBooking.add(carBook);
        car.markAsBooked();
    }
    public List<CarBooking> getCarBooking(){
        return carBooking;
    }



    public List<Car> getUserBookedCars(User user){
        List<Car> carsBookedByUser =new ArrayList<>();
        for(var userCars : getCarBooking()) {
            if (userCars != null && userCars.getUser() != null && userCars.getUser().equals(user)){
                carsBookedByUser.add(userCars.getCar());
            }
        }
        if (carsBookedByUser.isEmpty()) {
            System.out.println("No booking found for user: " + user.getName() + " and ID: " +user.getId());
        }

        return carsBookedByUser;
    }
//   public Car[] getUserBookedCars(User user){
////        System.out.println(Arrays.toString(getCarBooking()));
//
//        int capacity =0;
//        Car[] carsBookedByUser =new Car[10];
//        for(var userCars : getCarBooking()) {
//            if (userCars != null && userCars.getUser() != null && userCars.getUser().equals(user)){
//                carsBookedByUser[capacity++] = userCars.getCar();
//            }
//        }
//        if (capacity == 0) {
//            System.out.println("No booking found for user: " + user.getName() + " " +user.getId());
//        }
//        carsBookedByUser = Arrays.copyOf(carsBookedByUser, capacity);
//        return carsBookedByUser;
//    }



}
