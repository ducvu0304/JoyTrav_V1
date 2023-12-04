package com.JoyTrav.dto;

public class BookingSummary {
    private TourDTO tourDTO;
    private int adultsNumber;
    private int childrenNumber;
    private int toddlersNumber;
    private int infantsNumber;
    private int total;

    public BookingSummary() {
    }

    public TourDTO getTourDTO() {
        return tourDTO;
    }

    public void setTourDTO(TourDTO tourDTO) {
        this.tourDTO = tourDTO;
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
}
