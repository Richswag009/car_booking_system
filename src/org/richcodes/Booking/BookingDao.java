package org.richcodes.Booking;

import org.richcodes.Car.Car;
import org.richcodes.CarBooking.CarBooking;
import org.richcodes.User.User;

import java.util.Arrays;

public class BookingDao {

    private final CarBooking[] carBooking;
    private int count;
    public  BookingDao(int capacity){
        carBooking = new CarBooking[capacity];
        count=0;

    }

    public void addBooking(User user, Car car){
        CarBooking carBook= new CarBooking(user, car);
        carBooking[count]=carBook;
        car.markAsBooked();
        count++;

    }
    public CarBooking[] getCarBooking(){
        return carBooking;
    }



    public Car[] getUserBookedCars(User user){
//        System.out.println(Arrays.toString(getCarBooking()));

        int capacity =0;
        Car[] carsBookedByUser =new Car[10];
        for(var userCars : getCarBooking()) {
            if (userCars != null && userCars.getUser() != null && userCars.getUser().equals(user)){
                carsBookedByUser[capacity++] = userCars.getCar();
            }
        }
        if (capacity == 0) {
            System.out.println("No booking found for user: " + user.getName() + " " +user.getId());
        }
        carsBookedByUser = Arrays.copyOf(carsBookedByUser, capacity);
        return carsBookedByUser;
    }



}
