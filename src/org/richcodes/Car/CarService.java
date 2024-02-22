package org.richcodes.Car;

public class CarService {

    private final CarDao carDao;

    public CarService(){
        this.carDao = new CarDao();

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
            throw new IllegalArgumentException("name cannot be blank");
        }
        return carDao.getCarByRegNo(regNo);
    }

    public void getAvailableCars(){
        for (var cars: carDao.availableCars()){
            System.out.println(cars);
        }
//        System.out.println(Arrays.toString(carDao.availableCars()));
    }

}
