package com.JoyTrav.service;

import com.JoyTrav.dto.BookingDTO;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingService extends IGenericService<Booking, String> {
    Booking covertBookingDTOToBooking(BookingDTO bookingDTO, Customer customer);

    boolean changeStatus (String bookingId);
}
