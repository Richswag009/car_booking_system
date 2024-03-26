package org.richcodes.Car;


import org.richcodes.Brand;
import org.richcodes.exceptions.UserNotFoundException;

import java.util.Optional;

public class CarService {
    private final CarDao carDao = new CarDao();


    public Car getCarByRegNo(String regNo){
        if (regNo.isBlank()){
            System.out.println("please enter the regNo of the car ");
        }
        return (carDao.getCarByRegNo(regNo));
    }

    public void getAvailableCars(){
        carDao.availableCarsUsingStreams().forEach(System.out::println);
    }

    public void getElectricCars(){
        carDao.getAllElectricCars().forEach(System.out::println);
    }

    public  void registerCar(String driverName, Brand brand, String regNo, boolean isElectric){
        if(driverName.isBlank() || regNo.isBlank()){
            System.out.println("field cannot be blank");
        }
        if(carDao.carRegNoExist(regNo)){
            System.out.println("Car with Reg NO -> "+ regNo + "  already exists");
            return;
        }
        carDao.addCar(driverName,brand,regNo,isElectric);
    }

    public void fetchAllCars(){
        carDao.fetchCars().forEach(System.out::println);
    }

    public Car findCarByRegNo(String carRegNo) {
        Optional<Car> userOptional = carDao.fetchCarByRegNo(carRegNo);
        return userOptional.orElseThrow(() ->
                new UserNotFoundException("Car with car Registration " + carRegNo + " not found"));
    }

    public void findAvailableCars(){
        carDao.fetchCars().stream()
                .filter(s->!s.getCarIsBooked()).forEach(System.out::println);
    }

    public  void findElectricCars(){
        carDao.fetchCars().stream().filter(Car::isElectric).forEach(System.out::println);
    }

}
