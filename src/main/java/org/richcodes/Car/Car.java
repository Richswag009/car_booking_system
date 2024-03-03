package org.richcodes.Car;

import org.richcodes.Brand;

public class Car {
    private String name;
    private Brand brand;
    private String regNO;
    private boolean isBooked;
    private boolean isElectric;

    public Car(){}

    public Car(String name, Brand brand, String regNO, boolean isElectric) {
        this.name = name;
        this.brand = brand;
        this.regNO = regNO;
        this.isBooked= false;
        this.isElectric= isElectric;
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

    public boolean isElectric() {
        return isElectric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand=" + brand +
                ", regNO='" + regNO + '\'' +
                ", isBooked=" + isBooked +
                ", isElectric=" + isElectric +
                '}';
    }
}