package com.fmellberg.itemlendr.booking.service;

import com.fmellberg.itemlendr.booking.model.BookingEntity;
import com.fmellberg.itemlendr.booking.repository.BookingRepository;
import com.fmellberg.itemlendr.errorhandling.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    public BookingEntity getBookingById(long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", bookingId));
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity updateBooking(BookingEntity updatedBooking) {
        if (!bookingRepository.existsById(updatedBooking.getId())) {
            throw new ResourceNotFoundException("Booking", "id", updatedBooking.getId());
        }

        return bookingRepository.save(updatedBooking);
    }

    @Override
    public void deleteBooking(long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new ResourceNotFoundException("Booking", "id", bookingId);
        }

        bookingRepository.deleteById(bookingId);
    }
}
