package org.richcodes.CarBooking;

import org.richcodes.Car.Car;
import org.richcodes.User.User;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {

    private User user;
    private Car car;
    private UUID bookingRef;
    private Date dateCreated;

    public  CarBooking(){}

    public CarBooking(User user, Car car){
        this.user=user;
        this.car= car;
        this.bookingRef= UUID.randomUUID();
        this.dateCreated= new Date();


    }

    public CarBooking(int capacity) {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public UUID getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(UUID bookingRef) {
        this.bookingRef = bookingRef;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }



    @Override
    public String toString() {
        return "CarBookings{ " +
                "user= " + user +
                ", car= " + car +
                ", bookingRef= " + bookingRef +
                ", dateCreated= " + dateCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(bookingRef, that.bookingRef) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car, bookingRef, dateCreated);
    }

}
