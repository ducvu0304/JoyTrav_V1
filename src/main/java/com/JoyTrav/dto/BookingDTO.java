package com.JoyTrav.dto;


import java.util.Date;

public class BookingDTO {

    private String paymentMethod;
    private int totalPayment;

    public BookingDTO() {
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
}
