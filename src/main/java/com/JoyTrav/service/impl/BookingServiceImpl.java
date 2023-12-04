package com.JoyTrav.service.impl;

import com.JoyTrav.dto.BookingDTO;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Tour;
import com.JoyTrav.repository.BookingRepository;
import com.JoyTrav.service.BookingService;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private IdGenerator idGenerator;

    @Override
    public List<Booking> fetchALl() {
        return null;
    }

    @Override
    public Optional<Booking> getById(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public void create(Booking booking) {

    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public boolean existsById(String bookingId) {

        return false;
    }

    @Override
    public Booking covertBookingDTOToBooking(BookingDTO bookingDTO, Customer customer) {
        Booking booking = new Booking();

        booking.setId(idGenerator.generateBookingID());
        booking.setBookingDate(new Date());
        booking.setPayment(bookingDTO.getPaymentMethod());
        booking.setStatus("pending");
        booking.setTotal(bookingDTO.getTotalPayment());
        booking.setCustomer(customer);

        return booking;
    }

    @Override
    public boolean changeStatus(String bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);

        if(booking.isPresent()) {
            booking.get().setStatus("completion");
            return true;
        }

        return false;
    }
}
