package org.richcodes;

import org.richcodes.Booking.BookingService;
import org.richcodes.Car.Car;
import org.richcodes.Car.CarService;
import org.richcodes.User.User;
import org.richcodes.User.UserService;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user= new User("riches");
        User user1= new User("gbenga");
//
        UserService service = new UserService();
        CarService carService = new CarService();
        UserService userService = new UserService();
        service.addUser(user1);
        service.addUser(user);
//        System.out.println(Arrays.toString(service.getUsers()));
        System.out.println(service.findUserByName("riches"));
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println(Arrays.toString(carService.getAllCars()));
//        System.out.println(carService.findUserByName("P4HYD321"));
        Car car =carService.findUserByName("L9HYD32");
        Car car1 =carService.findUserByName("O0RHYD32");
        Car car2 =carService.findUserByName("M7YD32");
        Car car3 =carService.findUserByName("B4HGK30");

        BookingService bookingService= new BookingService(10);
        bookingService.addBooking(user,car);
        bookingService.addBooking(user,car1);
        bookingService.addBooking(user1,car2);
        System.out.println("-------------------------");
//        System.out.println(Arrays.toString(bookingService.getAllBookings()));
        var bookings = bookingService.getAllBookings();
        for(var booking: bookings){
            System.out.println(booking);
        }
        bookingService.getUserBookedCars(user1);
        System.out.println();
        System.out.println("------------");
        carService.getAvailableCars();
        System.out.println("------------");
        userService.getUsers();
        bookingService.addBooking(user,car3);
        System.out.println("------------");
        carService.getAvailableCars();


//
//        int[] numbers = {1,1,1,2,2,8,9};
//        int[] number = {1,2,3,4};
//        System.out.println(Arrays.toString(middleNumber(number)));
//        System.out.println(removeDuplicates(numbers));
//        System.out.println(bestTimeToBuy(numbers));


    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;

    }

    static  int bestTimeToBuy(int[] prices){
        int maxProfit = 0;
        int leftPointer =0;

        for (int rightpointer =0; rightpointer< prices.length; rightpointer++){
            if(prices[leftPointer] < prices[rightpointer]){
                int profit = prices[rightpointer] - prices[leftPointer];
                 maxProfit = Math.max(profit,maxProfit);
            }
            else {
                leftPointer = rightpointer;
            }
        }
        return maxProfit;

    }


//    static  int[] singleNumber()

}