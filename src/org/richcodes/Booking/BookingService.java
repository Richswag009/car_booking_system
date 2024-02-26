package org.richcodes.Booking;

import org.richcodes.Car.Car;
import org.richcodes.CarBooking.CarBooking;
import org.richcodes.User.User;

import java.util.List;

public class BookingService {

  private final BookingDao bookingDao;


  public BookingService(BookingDao bookingDao){
    this.bookingDao = bookingDao;
  }

  public void addBooking(User user, Car car){
    if (user.getId() == null || car.getCarIsBooked()){
//      throw new IllegalArgumentException("cannot booked call as either dosent exist or car is booked");
      System.out.println("cannot booked call as either dosent exist or car is booked");
    }
    bookingDao.addBooking(user,car);
    System.out.println("successfully booked car " + car.getRegNO());
  }

  public List<CarBooking> getAllBookings() {
    if (bookingDao.getCarBooking().isEmpty()){
      System.out.println("No Booking have been made yet");
    }
    return bookingDao.getCarBooking();
  }

  public void getUserBookedCars(User user){
    bookingDao.getUserBookedCars(user).forEach(System.out::println);
//    System.out.println((bookingDao.getUserBookedCars(user)));
  }



}
