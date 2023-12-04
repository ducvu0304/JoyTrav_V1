package com.JoyTrav.dto;

import com.JoyTrav.model.Customer;

import java.util.List;

public class BookingDetail {
    private String tourId;
    private BookingDTO booking;
    private List<PassengerDTO> passengerList;
    private CustomerDTO customerData;

    public BookingDetail() {
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    public List<PassengerDTO> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<PassengerDTO> passengerList) {
        this.passengerList = passengerList;
    }

    public CustomerDTO getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerDTO customerData) {
        this.customerData = customerData;
    }
}
