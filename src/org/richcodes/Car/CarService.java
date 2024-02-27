package org.richcodes.Car;


public class CarService {
    private final CarDao carDao;

    public CarService(CarDao carDao){
        this.carDao = carDao;

    }
    public boolean addCar(Car car){
        if(car.getRegNO().isEmpty()){
            throw new IllegalArgumentException(
                    "Reg Number cannot be null"
            );
        }
        System.out.println("Successfully added Car");
        return  true;
    }

    public Car[] getAllCars(){
        return carDao.getCars();
    }

    public Car findUserByName(String regNo){
        if (regNo.isBlank()){
//            throw new IllegalArgumentException("name cannot be blank");
            System.out.println("please enter the regNo of the car ");
        }
        return carDao.getCarByRegNo(regNo);
    }

    public void getAvailableCars(){
//        for (var cars: carDao.availableCars()){
//            System.out.println(cars);
//        }
//        using method reference
        carDao.availableCars().forEach(System.out::println);
    }
    public void getElectricCars(){
//        for (var cars: carDao.getElectricCars()){
//            System.out.println(cars);
//        }
        carDao.getElectricCars().forEach(System.out::println);
    }

}
