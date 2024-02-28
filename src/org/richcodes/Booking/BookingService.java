package org.richcodes.Booking;

import org.richcodes.Car.CarService;
import org.richcodes.User.UserService;

public class BookingService {
  private final BookingDao bookingDao;
  private final UserService userService;
  private final CarService carService;

  public BookingService(BookingDao bookingDao, UserService userService, CarService carService) {
      this.bookingDao = bookingDao;
      this.userService = userService;
      this.carService = carService;
  }

  public void addBooking(String userName, String carName){
    var user = userService.findUserByName(userName);
    var car = carService.findUserByName(carName);
    if (user == null || car.getCarIsBooked()){
        System.out.println("Cannot be booked can as car is already booked");
        return ;

    }
    bookingDao.addBooking(user,car);
    System.out.println("successfully booked car " + car.getRegNO());

  }


  public void getAllBookings() {
    if (bookingDao.getCarBooking().isEmpty()){
      System.out.println("No Booking have been made yet");
    }
    bookingDao.getCarBooking().forEach(System.out::println);
  }

  public void getUserBookedCars(String username){
   var user = userService.findUserByName(username);
    bookingDao.getUserBookedCars(user).forEach(System.out::println);
  }


}
