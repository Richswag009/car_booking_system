package org.richcodes.Car;

import org.richcodes.Brand;

public class Car {
    private String name;
//    private String model;
    private Brand brand;
    private String regNO;
    private boolean isBooked;

    public Car(){}

    public Car(String name, Brand brand, String regNO) {
        this.name = name;
        this.brand = brand;
        this.regNO = regNO;
        this.isBooked= false;
    }
    public  Car(String regNO){
        this.regNO = regNO;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getRegNO() {
        return regNO;
    }

    public  boolean getCarIsBooked(){
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public void markAsBooked() {
        this.isBooked = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "driverName='" + name + '\'' +
                ", model='" + brand + '\'' +
                ", regNO='" + regNO + '\'' +
                ", carIsBooked='" + isBooked + '\'' +
                '}';
    }
}
