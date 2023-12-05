package com.JoyTrav.dto;

public class SearchObj {
    private String destination;
    private int minPrice;
    private int maxPrice;
    private String typeTour;
    private String category;


    public SearchObj() {
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getTypeTour() {
        return typeTour;
    }

    public void setTypeTour(String typeTour) {
        this.typeTour = typeTour;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SearchObj{" +
                "destination='" + destination + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", typeTour='" + typeTour + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
