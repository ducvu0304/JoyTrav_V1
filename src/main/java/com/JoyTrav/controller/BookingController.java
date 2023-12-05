package com.JoyTrav.controller;

import com.JoyTrav.dto.*;
import com.JoyTrav.model.Booking;

import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Passenger;
import com.JoyTrav.model.Tour;
import com.JoyTrav.service.BookingService;
import com.JoyTrav.service.CustomerService;
import com.JoyTrav.service.PassengerService;
import com.JoyTrav.service.TourService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TourService tourService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private BookingService bookingService;



    @PostMapping(value = "/booking-detail/processBooking", consumes = "application/json", produces = "application/json")
    public PaymentDetail processBookingDetail(@RequestBody BookingDetail bookingDetail) {
        PaymentDetail paymentDetail =  new PaymentDetail();
        Optional<Tour> tour = tourService.getById(bookingDetail.getTourId());

        Customer customer =   customerService.covertToCustomer(bookingDetail.getCustomerData(), tour);
        customerService.save(customer);

        Booking booking =
                bookingService.covertBookingDTOToBooking(bookingDetail.getBooking(), customer);
        bookingService.save(booking);

        for (PassengerDTO passengerDTO : bookingDetail.getPassengerList()) {
            Passenger passenger = passengerService.convertPassengerDTOToPassenger(passengerDTO, booking);
            passengerService.save(passenger);
        }

        paymentDetail.setTourId(bookingDetail.getTourId());
        paymentDetail.setBookingId(booking.getId());
        paymentDetail.setCustomerId(customer.getId());


        return paymentDetail;
    }

    @PostMapping(value = "/tour/search")
    public ResponseEntity<?> search(@RequestBody SearchObj searchObj) {
        Tour tour = tourService.searchTour(searchObj);

        System.out.println(tour.getId());

        return new ResponseEntity<>(tour.getId(), HttpStatus.OK);
    }

}
