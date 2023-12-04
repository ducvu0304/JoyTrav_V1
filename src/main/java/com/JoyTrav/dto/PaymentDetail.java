package com.JoyTrav.dto;

import com.JoyTrav.model.Passenger;

import java.util.List;

public class PaymentDetail {
    private String tourId;
    private String bookingId;
    private int customerId;

    public PaymentDetail() {
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
