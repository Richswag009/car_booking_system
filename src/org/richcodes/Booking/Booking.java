package org.richcodes.Booking;

import org.richcodes.CarBooking.CarBooking;

import java.util.Arrays;
import java.util.Objects;

public class Booking {
    private final CarBooking[] carBookings;
    private final int count;



    public Booking( int capacity ) {
        this.carBookings= new CarBooking[capacity] ;
        count= 0;
    }

    public CarBooking[] getCarBookings() {
        return carBookings;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "carBookings=" + Arrays.toString(carBookings) +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return count == booking.count && Arrays.equals(carBookings, booking.carBookings);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(carBookings);
        return result;
    }
}
