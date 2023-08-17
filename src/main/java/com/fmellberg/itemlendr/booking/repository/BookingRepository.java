package com.fmellberg.itemlendr.booking.repository;

import com.fmellberg.itemlendr.booking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}
