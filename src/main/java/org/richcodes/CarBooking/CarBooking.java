package org.richcodes.CarBooking;

import jakarta.persistence.*;
import org.richcodes.Car.Car;
import org.richcodes.User.User;
import org.richcodes.Utils.BookingRef;

import java.util.Objects;

@Entity
@Table(name = "car_bookings")
public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "bookingRef")
    private String bookingRef;


    public CarBooking() {
    }

    public CarBooking(User user, Car car){
        this.user=user;
        this.car= car;
        this.bookingRef= new BookingRef().generateId();


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

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }



    @Override
    public String toString() {
        return "CarBookings{ " +
                "user= " + user +
                ", car= " + car +
                ", bookingRef= " + bookingRef +
//                ", dateCreated= " + dateCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(bookingRef, that.bookingRef) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car, bookingRef);
    }

}
