package com.fmellberg.itemlendr.booking.service;

import com.fmellberg.itemlendr.booking.model.BookingEntity;

import java.util.List;

public interface BookingService {

    BookingEntity createBooking(BookingEntity booking);

    BookingEntity getBookingById(long bookingId);

    List<BookingEntity> getAllBookings();

    BookingEntity updateBooking(BookingEntity updatedBooking);

    void deleteBooking(long bookingId);
}
