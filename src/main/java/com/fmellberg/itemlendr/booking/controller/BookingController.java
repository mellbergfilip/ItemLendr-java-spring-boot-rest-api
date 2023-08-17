package com.fmellberg.itemlendr.booking.controller;

import com.fmellberg.itemlendr.booking.model.BookingEntity;
import com.fmellberg.itemlendr.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingEntity> createBooking(@RequestBody BookingEntity booking) {
        BookingEntity createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/get/{bookingId}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable Long bookingId) {
        BookingEntity booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<BookingEntity>> getAllBookings() {
        List<BookingEntity> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/update")
    public ResponseEntity<BookingEntity> updateBooking(@RequestBody BookingEntity updatedBooking) {
        BookingEntity updated = bookingService.updateBooking(updatedBooking);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking deleted");
    }
}
