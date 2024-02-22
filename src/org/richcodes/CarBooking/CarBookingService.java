package org.richcodes.CarBooking;

import org.richcodes.Car.Car;
import org.richcodes.User.User;

public class CarBookingService {

    private CarBookingDao carBookingDao;

    public CarBookingService(){
        this.carBookingDao= new CarBookingDao();
    }

    public  boolean addBookings(User user,Car car){
//        if(car.isBooked()){
//            throw new IllegalArgumentException(" car is already booked ");
//        }
//
//
//
        return true;

    }
}
