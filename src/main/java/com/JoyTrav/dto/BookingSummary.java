package com.JoyTrav.dto;

public class BookingSummary {
    private TourDetail tourDetail;
    private int adultsNumber;
    private int childrenNumber;
    private int toddlersNumber;
    private int infantsNumber;

    private int adultsPrice;
    private int childrenPrice;
    private int total;

    public BookingSummary() {
    }

    public TourDetail getTourDetail() {
        return tourDetail;
    }

    public void setTourDetail(TourDetail tourDetail) {
        this.tourDetail = tourDetail;
    }

    public int getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public int getToddlersNumber() {
        return toddlersNumber;
    }

    public void setToddlersNumber(int toddlersNumber) {
        this.toddlersNumber = toddlersNumber;
    }

    public int getInfantsNumber() {
        return infantsNumber;
    }

    public void setInfantsNumber(int infantsNumber) {
        this.infantsNumber = infantsNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAdultsPrice() {
        return adultsPrice;
    }

    public void setAdultsPrice(int adultsPrice) {
        this.adultsPrice = adultsPrice;
    }

    public int getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(int childrenPrice) {
        this.childrenPrice = childrenPrice;
    }
}

