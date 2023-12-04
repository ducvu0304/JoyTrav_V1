package com.JoyTrav.repository;

import com.JoyTrav.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, String> {
}
