package org.richcodes;

import org.richcodes.Booking.BookingService;
import org.richcodes.Car.Car;
import org.richcodes.Car.CarService;
import org.richcodes.User.User;
import org.richcodes.User.UserService;

import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        menu();
//        UserService userService = new UserService();
//        String uuidString = "0236e9db-8c46-45a1-8fef-718d12e271f3";
//        UUID uuid = UUID.fromString(uuidString);
//        userService.findUserById(uuid);

    }


   static public void menu(){
        Scanner scanner = new Scanner(System.in);
       BookingService bookingService= new BookingService(10);
       CarService carService = new CarService();
       UserService userService = new UserService();
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
            if(choice == 1){
                System.out.println("\n available cars");
                carService.getAvailableCars();
                System.out.print("→ - Enter Car reg no:");

                String carReg = scanner.nextLine();
                Car car= carService.findUserByName(carReg);
                System.out.println();
                userService.getUsers();
                System.out.print("→ - Please Enter your user ID: ");
                String userId = scanner.nextLine();
                UUID uuid = UUID.fromString(userId);
                User user = userService.findUserById(uuid);
                bookingService.addBooking(user,car);
            } else if (choice == 2) {
                userService.getUsers();
                System.out.print("→ - Please Enter Your ID: ");
                String uuidString = scanner.nextLine();
                UUID uuid = UUID.fromString(uuidString);
                User user = userService.findUserById(uuid);
                bookingService.getUserBookedCars(user);
            }
            else if(choice ==3){
                var bookings = bookingService.getAllBookings();
                for(var booking: bookings){
                    System.out.println(booking);
                }
            }else if(choice ==4){
                carService.getAvailableCars();
            }else if(choice ==5){
                carService.getElectricCars();
            }else if(choice ==6){
                userService.getUsers();
            }
            else if(choice ==7){
                break;
            }else{
                System.out.println("✖ -- invalid number selected");
            }
        }
    }

}


//
//        int[] numbers = {1,1,1,2,2,8,9};
//        int[] number = {1,2,3,4};
//        System.out.println(Arrays.toString(middleNumber(number)));
//        System.out.println(removeDuplicates(numbers));
//        System.out.println(bestTimeToBuy(numbers));

//    static int removeDuplicates(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int i = 0;
//
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return i + 1;
//
//    }
//
//    static  int bestTimeToBuy(int[] prices){
//        int maxProfit = 0;
//        int leftPointer =0;
//
//        for (int rightpointer =0; rightpointer< prices.length; rightpointer++){
//            if(prices[leftPointer] < prices[rightpointer]){
//                int profit = prices[rightpointer] - prices[leftPointer];
//                 maxProfit = Math.max(profit,maxProfit);
//            }
//            else {
//                leftPointer = rightpointer;
//            }
//        }
//        return maxProfit;
//
//    }


//    static  int[] singleNumber()