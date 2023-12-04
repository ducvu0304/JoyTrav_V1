package com.JoyTrav.service;

import com.JoyTrav.dto.OfferTour;
import com.JoyTrav.dto.Pagination;
import com.JoyTrav.dto.TourDTO;
import com.JoyTrav.dto.TourDetail;
import com.JoyTrav.model.Tour;

import java.util.List;

public interface TourService extends IGenericService<Tour, String> {
    List<OfferTour> fetchFirstOffers();
    List<OfferTour> fetchSecondOffers();
    Pagination<Tour> findPage(int page);
    TourDTO covertToTourDTO(String tourId);
    TourDetail convertToTourDetail(Tour tour);
}
