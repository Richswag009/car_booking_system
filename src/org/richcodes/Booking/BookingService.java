package org.richcodes.Booking;

import org.richcodes.Car.Car;
import org.richcodes.CarBooking.CarBooking;
import org.richcodes.User.User;

import java.util.Arrays;

public class BookingService {

  private BookingDao bookingDao;

  public BookingService(int capacity){
      bookingDao= new BookingDao(capacity);
  }

  public boolean addBooking(User user, Car car){
    if (user.getId() == null || car.getCarIsBooked()){
      throw new IllegalArgumentException("cannot booked call as either dosent exist or car is booked");
    }
    bookingDao.addBooking(user,car);
    System.out.println("successfully booked car " + car.getRegNO());
    return true;
  }

  public CarBooking[] getAllBookings() {
    return bookingDao.getCarBooking();
  }

  public void getUserBookedCars(User user){
   if(user.getName().isBlank()){
     throw new IllegalArgumentException("user id dose n0t exist");
   }
    System.out.println(Arrays.toString(bookingDao.getUserBookedCars(user)));
  }




}
