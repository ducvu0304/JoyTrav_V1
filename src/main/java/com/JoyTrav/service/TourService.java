package com.JoyTrav.service;

import com.JoyTrav.dto.*;
import com.JoyTrav.model.Tour;

import java.util.List;

public interface TourService extends IGenericService<Tour, String> {
    List<OfferTour> fetchFirstOffers();
    List<OfferTour> fetchSecondOffers();
    List<Tour> findPage(int page, List<Tour> tours);
    TourDTO covertToTourDTO(String tourId);
    TourDetail convertToTourDetail(Tour tour);
    List<Tour> getTourByType(String type);

    Tour searchTour(SearchObj searchObj);
}
