package com.JoyTrav.service.impl;

import com.JoyTrav.dto.OfferTour;
import com.JoyTrav.dto.Pagination;
import com.JoyTrav.dto.TourDTO;
import com.JoyTrav.dto.TourDetail;
import com.JoyTrav.model.Picture;
import com.JoyTrav.model.Tour;
import com.JoyTrav.repository.TourRepository;
import com.JoyTrav.service.TourService;
import com.JoyTrav.utils.ConvertObject;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository touRepository;
    @Autowired
    private IdGenerator generator;
    @Autowired
    private ConvertObject convertObject;

    @Override
    public List<Tour> fetchALl() {
        return null;
    }

    @Override
    public List<OfferTour> fetchFirstOffers() {
        List<Tour> saleTours = touRepository.findAll().stream().filter(tour -> tour.getSale().equals("30")).collect(Collectors.toList());
        List<OfferTour> firstOffers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            OfferTour offerTour = new OfferTour();
            offerTour.setId(saleTours.get(i).getId());
            offerTour.setTitle(saleTours.get(i).getTitle());
            offerTour.setSale(saleTours.get(i).getSale());

            List<Picture> pictureList =  saleTours.get(i).getPictureList();
            String link =  pictureList.get(0).getLink();

            offerTour.setPicture(link);
            firstOffers.add(offerTour);
        }

        return firstOffers;
    }

    @Override
    public List<OfferTour> fetchSecondOffers() {
        List<Tour> saleTours =
                touRepository.findAll().stream()
                        .filter(tour -> tour.getSale().equals("30")).collect(Collectors.toList());
        saleTours.sort(Comparator.comparing(Tour::getId).reversed());

        List<OfferTour> secondOffers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            OfferTour offerTour = new OfferTour();
            offerTour.setId(saleTours.get(i).getId());
            offerTour.setTitle(saleTours.get(i).getTitle());
            offerTour.setSale(saleTours.get(i).getSale());

            List<Picture> pictureList =  saleTours.get(i).getPictureList();
            String link =  pictureList.get(0).getLink();

            offerTour.setPicture(link);
            secondOffers.add(offerTour);
        }

        return secondOffers;
    }

    @Override
    public Pagination<Tour> findPage(int page) {
        Pagination<Tour> pagination = new Pagination<>();
        pagination.setCurrentPage(page);
        pagination.setPageSIze(5);

        int totalPage = Math.round(touRepository.findAll().size()/ pagination.getPageSIze());
        pagination.setTotalPage(totalPage);

        int offset = (page-1) * pagination.getPageSIze();

        pagination.setList(touRepository.findTourPage(pagination.getPageSIze(), offset));

        if(pagination.getTotalPage() > 0) {
            pagination.setPageNumbers(generator.pageNumbers(totalPage));
        }

        return pagination;
    }

    @Override
    public TourDTO covertToTourDTO(String tourId) {
        Optional<Tour> tour = getById(tourId);

        if(tour.isPresent()) {
            TourDTO tourDTO =  new TourDTO();

            tourDTO.setTourId(tour.get().getId());
            tourDTO.setTitle(tour.get().getTitle());
            tourDTO.setPrice((int)tour.get().getPrice());
            tourDTO.setImage(tour.get().getPictureList().get(0).getLink());
            tourDTO.setSale(tour.get().getSale());
            tourDTO.setDeparture(tour.get().getDeparture());
            tourDTO.setDepartDate(tour.get().getDepartureDate());


            return tourDTO;
        }

        return null;
    }

    @Override
    public TourDetail convertToTourDetail(Tour tour) {
        TourDetail tourDetail =  new TourDetail();
        tourDetail.setTourId(tour.getId());
        tourDetail.setTitle(tour.getTitle());
        tourDetail.setIntro(tour.getIntro());
        tourDetail.setPrice((int)tour.getPrice());
        tourDetail.setSlots(tourDetail.getSlots());
        tourDetail.setDeparture(tour.getDeparture());
        tourDetail.setDestination(tour.getDestination());
        tourDetail.setDuration(tour.getDuration());
        tourDetail.setVehicle(tour.getVehicle());
        tourDetail.setDepartDate(tour.getDepartureDate());
        tourDetail.setSale(convertObject.convertSaleValue(tour.getSale()));
        tourDetail.setImages(tour.getPictureList());
        tourDetail.setSchedules(tour.getSchedules());

        return tourDetail;
    }

    @Override
    public Optional<Tour> getById(String tourID) {
        return touRepository.findById(tourID);
    }

    @Override
    public void create(Tour tour) {

    }

    @Override
    public void save(Tour tour) {
        touRepository.save(tour);
    }

    @Override
    public boolean existsById(String integer) {
        return false;
    }


}
