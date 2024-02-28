package org.richcodes.Car;


public class CarService {
    private final CarDao carDao = new CarDao();

    public Car[] getAllCars(){
        return carDao.getCars();
    }

    public Car findUserByName(String regNo){
        if (regNo.isBlank()){
            System.out.println("please enter the regNo of the car ");
        }
        return carDao.getCarByRegNo(regNo);
    }

    public void getAvailableCars(){
        carDao.availableCarsUsingStreams().forEach(System.out::println);
    }

    public void getElectricCars(){
        carDao.getAllElectricCars().forEach(System.out::println);
    }

}
