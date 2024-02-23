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

  public BookingService(BookingDao bookingDao){
    this.bookingDao = bookingDao;
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
    if (bookingDao.getCarBooking().length == 0){
      System.out.println("No Booking have been made yet");
    }
    return bookingDao.getCarBooking();
  }

  public void getUserBookedCars(User user){
    System.out.println(Arrays.toString(bookingDao.getUserBookedCars(user)));
  }



}
