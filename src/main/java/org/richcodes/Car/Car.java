package org.richcodes.Car;

import jakarta.persistence.*;
import org.richcodes.Brand;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    @Column(name = "driverName")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand")
    private Brand brand;
    @Column(name = "regNo")
    private String regNO;
    @Column(name = "isBooked")
    private boolean isBooked;
    @Column(name = "isElectric")
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
