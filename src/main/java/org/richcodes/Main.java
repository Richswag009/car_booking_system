package org.richcodes;

import org.richcodes.Car.CarService;
import org.richcodes.CarBooking.CarBookingService;
import org.richcodes.User.UserService;

import java.util.Scanner;

public class Main {
    private final UserService userService;
    private final CarService carService;
//    private final  BookingService bookingService;
    private final CarBookingService carBookingService ;


    public Main( UserService userService, CarService carService, CarBookingService carBookingService) {
        this.userService = userService;
        this.carService = carService;
        this.carBookingService = carBookingService;
//        this.bookingService= new BookingService(bookingDao, userService, carService);
//
    }

    public static void main(String[] args) {
//         BookingDao bookingDao = new BookingDao();
         UserService userService = new UserService();
         CarService carService = new CarService();
         CarBookingService carBookingService = new CarBookingService();
         System.out.println();
         System.out.println("Welcome to Zilly car Booking System!!!");
         Main mainInstance = new Main( userService, carService,carBookingService );
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
            System.out.println(" 7⃣ - Register a New User");
            System.out.println(" 8⃣ - Add a New Car");
            System.out.println(" 9⃣ - Fetch All Cars");
            System.out.println(" 0⃣ - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    newBookings();
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
                    addANewUser();
                    break;
                case 0:
                    System.out.println("Existing the Program");
                    return;
                case 8:
                    addANewCar();
                    break;
                case 9:
                    fetchAllCars();
                    break;
                default:
                    System.out.println("Invalid input");;
            }
        }
    }


    private  void viewAUserBooking() {
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Enter A Email ");
        String user = userScanner.nextLine();
       carBookingService.getUserBookingByEmail(user);
    }

    private  void viewAllBookings() {
        carBookingService.getBookings();
    }
    private  void viewAllAvailableCars() {
        carService.findAvailableCars();
    }
    private  void viewElectricCars() {
       carService.findElectricCars();
    }
    private void getAllUsers(){
        userService.allUsers();
    }
    private void fetchAllCars(){
        carService.fetchAllCars();
    }

    private void addANewUser(){
        Scanner userScanner = new Scanner(System.in);
        Scanner emailScanner = new Scanner(System.in);
        System.out.println("Enter A Username ");
        String user = userScanner.nextLine();
        System.out.println("Enter A email ");
        String email = emailScanner.nextLine();
        userService.addUser(user,email);
    }

    private void addANewCar(){
        Scanner driverNameScanner = new Scanner(System.in);
        Scanner carRegScanner = new Scanner(System.in);
        Scanner brandScanner = new Scanner(System.in);
        Scanner isElectricScanner = new Scanner(System.in);
        System.out.println("Enter A Driver name ");
        String user = driverNameScanner.nextLine();
        System.out.println("Enter A Car Registration Number ");
        String carRegNo = carRegScanner.nextLine();
        System.out.println("Enter the brand (TOYOTA, BMW, FORD,TESLA):");
        String brandInput = brandScanner.nextLine().toUpperCase();
        Brand brand = Brand.valueOf(brandInput);
        System.out.println("Enter true or false:");
        String userInput = isElectricScanner.nextLine().trim();
        boolean value = false;

        if (userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("false")) {
             value = Boolean.parseBoolean(userInput);
        }
        carService.registerCar(user,brand,carRegNo,value);
    }
//    private void findUserByEmail(){
//        Scanner emailScanner = new Scanner(System.in);
//        String email = emailScanner.nextLine();
//        userService.findUserByEmail(email);
//    }

    private void newBookings(){
        Scanner userNameScanner = new Scanner(System.in);
        Scanner carNameScanner = new Scanner(System.in);
        System.out.print("Enter Email:");
        String userName = userNameScanner.nextLine();
        carService.findAvailableCars();
        System.out.println("Enter car RegNo:");
        String carReg = carNameScanner.nextLine();
        carBookingService.addBookings(userName,carReg);
    }


}

