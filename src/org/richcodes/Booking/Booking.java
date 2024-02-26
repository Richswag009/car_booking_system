package org.richcodes.Booking;

import org.richcodes.CarBooking.CarBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking {
    private final List<CarBooking> carBookings;




    public Booking() {
        this.carBookings= new ArrayList<>();
    }

    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "carBookings=" + carBookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(carBookings, booking.carBookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBookings);
    }
}
