package org.richcodes;

import org.richcodes.Booking.BookingDao;
import org.richcodes.Booking.BookingService;
import org.richcodes.Car.CarService;
import org.richcodes.User.UserService;

import java.util.Scanner;

public class Main {
    private final BookingDao bookingDao;
    private final UserService userService;
    private final CarService carService;
    private final  BookingService bookingService;


    public Main(BookingDao bookingDao, UserService userService, CarService carService) {
        this.bookingDao = bookingDao;
        this.userService = userService;
        this.carService = carService;
        this.bookingService= new BookingService(bookingDao, userService, carService);
//
    }

    public static void main(String[] args) {
         BookingDao bookingDao = new BookingDao();
         UserService userService = new UserService();
         CarService carService = new CarService();
         System.out.println();
         System.out.println("Welcome to Zilly car Booking System!!!");
         Main mainInstance = new Main(bookingDao, userService, carService);
         mainInstance.menu();
    }

   private  void menu()
   {
       Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(" 1⃣ - Book Car ");
            System.out.println(" 2⃣ - View All User Booked Cars");
            System.out.println(" 3⃣ - View All Bookings");
            System.out.println(" 4⃣ - View Available Cars");
            System.out.println(" 5⃣ - View Available Electric Cars");
            System.out.println(" 6⃣ - View all users");
            System.out.println(" 7⃣ - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    bookACar();
                    break;
                case 2:
                    viewAUserBooking();
                    break;
                case 3:
                    viewAllBookings();
                    break;
                case 4:
                    viewAllAvailableCars();
                    break;
                case 5:
                    viewElectricCars();
                    break;
                case 6:
                    getAllUsers();
                    break;
                case 7:
                    System.out.println("Existing the Program");
                    return;
                default:
                    System.out.println("Invalid input");;
            }
        }
    }

    private  void bookACar() {
        Scanner userNameScanner = new Scanner(System.in);
        Scanner carNameScanner = new Scanner(System.in);
        userService.getUsers();
        System.out.print("Enter UserName:");
        String userName = userNameScanner.nextLine();
        carService.getAvailableCars();
        System.out.println("Enter car RegNo:");
        String carReg = carNameScanner.nextLine();
        bookingService.addBooking(userName,carReg);
    }
    private  void viewAUserBooking() {
        Scanner userScanner = new Scanner(System.in);
        userService.getUsers();
        System.out.println("Enter A Username ");
        String user = userScanner.nextLine();
       bookingService.getUserBookedCars(user);
    }

    private  void viewAllBookings() {
        bookingService.getAllBookings();
    }
    private  void viewAllAvailableCars() {
        carService.getAvailableCars();
    }
    private  void viewElectricCars() {
       carService.getElectricCars();
    }
    private void getAllUsers(){
        userService.getUsers();
    }


}

