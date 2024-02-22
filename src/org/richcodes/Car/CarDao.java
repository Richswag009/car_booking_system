package org.richcodes.Car;

import org.richcodes.Brand;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("promise", Brand.FORD,"34HYD32"),
                new Car("paul",Brand.TOYOTA,"B4HGK30"),
                new Car("riches",Brand.BMW,"P4HYD32"),
                new Car("poto",Brand.BMW,"M7YD32"),
                new Car("gbenga",Brand.FORD,"O0RHYD32"),
                new Car("elisha",Brand.TOYOTA,"L9HYD32"),
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
        return availableCars;
    }


}