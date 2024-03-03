package org.richcodes.Booking;

import org.richcodes.Car.Car;
import org.richcodes.Car.CarService;
import org.richcodes.User.User;
import org.richcodes.User.UserService;

import java.util.Optional;

public class BookingService {
  private final BookingDao bookingDao;
  private final UserService userService;
  private final CarService carService;

  public BookingService(BookingDao bookingDao, UserService userService, CarService carService) {
      this.bookingDao = bookingDao;
      this.userService = userService;
      this.carService = carService;
  }

//  public void addBooking(String userName, String carName){
//    var user = userService.findUserByName(userName);
//    var car = carService.getCarByRegNo(carName);
//    if (user==null || car.getCarIsBooked()){
//        System.out.println("Cannot be booked can as car is already booked");
//
//    }
//    bookingDao.addBooking(user,car);
//    System.out.println("successfully booked car " + car.getRegNO());
//
//  }

    public void addBooking(String userName, String carName) {
        Optional<User> userOptional = userService.findUserByName(userName);
        Optional<Car> carOptional = Optional.ofNullable(carService.getCarByRegNo(carName));
        if (userOptional.isPresent() && carOptional.isPresent() && !carOptional.get().getCarIsBooked()) {
            User user = userOptional.get();
            Car car = carOptional.get();
            bookingDao.addBooking(user, car);
            System.out.println("Successfully booked car " + car.getRegNO());
        } else {
            System.out.println("Cannot be booked as car is already booked or user not found");
        }
    }


  public void getAllBookings() {
    if (bookingDao.getCarBooking().isEmpty()){
      System.out.println("No Booking have been made yet");
    }
    bookingDao.getCarBooking().forEach(System.out::println);
  }

  public void getUserBookedCars(String username){
   Optional<User> userOptional = userService.findUserByName(username);
   if(userOptional.isPresent()){
       User user = userOptional.get();
       bookingDao.getAUserBookedCars(user).forEach(System.out::println);
   }else{
       System.out.println("no Booking found for user");
   }

  }


}
