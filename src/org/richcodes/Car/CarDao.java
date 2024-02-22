package org.richcodes.Car;

import org.richcodes.Brand;

import java.util.Arrays;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("promise", Brand.FORD,"34HYD32",false),
                new Car("paul",Brand.TESLA,"B4HGK30",true),
                new Car("riches",Brand.BMW,"P4HYD32",false),
                new Car("poto",Brand.TESLA,"M7YD32",true),
                new Car("gbenga",Brand.FORD,"O0RHYD32",false),
                new Car("elisha",Brand.TOYOTA,"L9HYD32",false),
                new Car("elisha",Brand.TESLA,"L9HYD32",true),
        };
    }

    public Car[] getCars() {
        return cars;
    }
    public Car getCarByRegNo(String name){
        for (var car : cars){
            if(car.getRegNO().equalsIgnoreCase(name)){
                System.out.println("found Car with a regNo: " + name);
                return car;
            }
        }
        System.out.println("Car not found");
        return null;
    }

    public Car[] getElectricCars(){
        int count= 0;
        Car[] electricCars = new Car[cars.length];
        for (var car: getCars()){
            if (car.isElectric() && !car.getCarIsBooked()){
                electricCars[count++]=car;
            }
        }
        if (electricCars.length == 0) {
            System.out.println("No Electric cars  available:");
        }
        electricCars = Arrays.copyOf(electricCars,count);
        return electricCars;
    }


    public Car[] availableCars(){
        int count= 0;
        Car[] availableCars = new Car[cars.length];
        for (var car: getCars()){
            if (!car.getCarIsBooked()){
                availableCars[count++]=car;
            }
        }
        if (count == 0) {
            System.out.println("No cars is available for booking: ");
        }
        availableCars= Arrays.copyOf(availableCars,count);
        return availableCars;
    }


}