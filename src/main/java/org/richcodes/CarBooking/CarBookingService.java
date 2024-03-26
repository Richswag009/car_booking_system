package org.richcodes.CarBooking;

public class CarBookingService {

    private final CarBookingDao carBookingDao;

    public CarBookingService(){
        this.carBookingDao= new CarBookingDao();
    }

    public  void addBookings(String email, String carRegNo){
       carBookingDao.addBooking(email,carRegNo);

    }

    public  void getBookings(){
        carBookingDao.getAllBookings().forEach(System.out::println);
    }

    public  void getUserBookingByEmail(String email){
        if(email.isEmpty() || email.isBlank()){
            System.out.println("field cannot be empty");
        }
        if(carBookingDao.getAUserBookings(email).size() > 1){
            System.out.println("=========================");
            carBookingDao.getAUserBookings(email).forEach(System.out::println);
        }else {
            System.out.println();
            System.out.println("=========================");
            System.out.println("No booking for Selected users");
        }


    }
}
