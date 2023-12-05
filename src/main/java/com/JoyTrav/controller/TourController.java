package com.JoyTrav.controller;

import com.JoyTrav.dto.*;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Group;
import com.JoyTrav.model.Tour;
import com.JoyTrav.service.BookingService;
import com.JoyTrav.service.CustomerService;
import com.JoyTrav.service.TourService;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TourController {

    private static final Pagination<Tour> TOUR_PAGINATION = new Pagination<>();

    @Autowired
    private IdGenerator generator;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TourService tourService;


    @GetMapping("/tour")
    public String tourPage(Model model) {
        int totalPage = tourService.fetchALl().size()/5;

        TOUR_PAGINATION.setTotalPage(totalPage);
        TOUR_PAGINATION.setList(tourService.fetchALl());
        TOUR_PAGINATION.setPageNumbers(generator.pageNumbers(totalPage));

        model.addAttribute("tourList", tourService.findPage(1, tourService.fetchALl()));
        model.addAttribute("pageNumbers", TOUR_PAGINATION.getPageNumbers());
        model.addAttribute("curPage",1);

        return "tour";
    }

    @GetMapping("/tour/page={page}")
    public String findPage(@PathVariable int page, Model model) {
        List<Tour> tours = tourService.findPage(page, TOUR_PAGINATION.getList());


        model.addAttribute("tourList", tours);
        model.addAttribute("pageNumbers", TOUR_PAGINATION.getPageNumbers());
        model.addAttribute("curPage",page);


        return "tour";
    }

    @GetMapping("/tour/type={tourType}")
    public String getTourByType(@PathVariable("tourType") String type, Model model) {
        List<Tour> list = tourService.getTourByType(type);
        int totalPage = list.size()/5;

        TOUR_PAGINATION.setList(list);
        TOUR_PAGINATION.setPageNumbers(generator.pageNumbers(totalPage));
        TOUR_PAGINATION.setCurrentPage(1);


        model.addAttribute("tourList", tourService.findPage(1, TOUR_PAGINATION.getList()));
        model.addAttribute("pageNumbers", TOUR_PAGINATION.getPageNumbers());
        model.addAttribute("curPage", TOUR_PAGINATION.getCurrentPage());

        return "tour";
    }

    @GetMapping("/tour/tourName={id}")
    public String viewTourDetail(@PathVariable String id, Model model) {
        Optional<Tour> tour = tourService.getById(id);

        if (tour.isPresent()) {
            TourDetail tourDetail = tourService.convertToTourDetail(tour.get());
            model.addAttribute("tourDetail", tourDetail);
            return "tour-details";
        } else {
            return "redirect:/tour";
        }
    }

    @GetMapping("/booking-detail/tourId={tourID}")
    public String viewBookingDetail(@PathVariable("tourID") String tourId, Model model) {
        Optional<Tour> optionalTour = tourService.getById(tourId);

        if (optionalTour.isPresent()) {
            TourDetail tourDetail = tourService.convertToTourDetail(optionalTour.get());

            model.addAttribute("tour", tourDetail);
            return "booking-details";
        }

        return "booking-details";
    }


    @GetMapping("/tour/tourName={id}/booking")
    public String viewBookingPage(@PathVariable String id, Model model) {
        Optional<Tour> tour = tourService.getById(id);

        model.addAttribute("customer", new Customer());

        if (tour.isPresent()) {
            model.addAttribute("tour", tour.get());
            return "tour-details";
        } else {
            return "redirect:/tour";
        }
    }

    @GetMapping("/tour/payment")
    public String displayPaymentPage(@RequestParam String bookingId,
                                     @RequestParam String tourId,
                                     @RequestParam int customerId,
                                     Model model) {

        CustomerDTO customerDTO = customerService.covertToCustomerDTO(customerId);

        int adultsNumber = 0;
        int childrenNumber = 0;
        int toddlersNumber = 0;
        int infantsNumber = 0;


        if (customerDTO != null) {
            model.addAttribute("customerInfo", customerDTO);
        }


        Optional<Booking> booking = bookingService.getById(bookingId);

        if (booking.isPresent()) {
            model.addAttribute("bookingInfo", booking.get());

            adultsNumber = booking.get().getPassengers()
                    .stream().filter(passenger -> passenger.getGroup().equals(Group.ADULTS)).toList().size();

            childrenNumber = booking.get().getPassengers()
                    .stream().filter(passenger -> passenger.getGroup().equals(Group.CHILDREN)).toList().size();

            toddlersNumber = booking.get().getPassengers()
                    .stream().filter(passenger -> passenger.getGroup().equals(Group.TODDLERS)).toList().size();

            infantsNumber = booking.get().getPassengers()
                    .stream().filter(passenger -> passenger.getGroup().equals(Group.INFANTS)).toList().size();
        }

        BookingSummary bookingSummary = new BookingSummary();
        Optional<Tour> optionalTour = tourService.getById(tourId);
        TourDetail tourDetail = null;
        if(optionalTour.isPresent()) {
            tourDetail = tourService.convertToTourDetail(optionalTour.get());
        }


        if (tourDetail != null) {
            bookingSummary.setTourDetail(tourDetail);
            bookingSummary.setTotal(booking.get().getTotal());
            bookingSummary.setAdultsNumber(adultsNumber);
            bookingSummary.setChildrenNumber(childrenNumber);
            bookingSummary.setChildrenNumber(infantsNumber);
            bookingSummary.setToddlersNumber(toddlersNumber);
        }


        model.addAttribute("bookingSummary", bookingSummary);

        return "payment";
    }

    @GetMapping("/payment/process-payment/bookingId={bookingId}")
    public String processPayment(@PathVariable String bookingId,
                                 Model model) {
        Optional<Booking> booking = bookingService.getById(bookingId);

        if (booking.isPresent()) {
            bookingService.changeStatus(bookingId);
            bookingService.save(booking.get());
            List<OfferTour> firstOffers = tourService.fetchFirstOffers();
            List<OfferTour> secondOffers = tourService.fetchSecondOffers();

            model.addAttribute("firstOffers", firstOffers);
            model.addAttribute("secondOffers", secondOffers);
            model.addAttribute("paymentStatus", true);
        }

        return "home";
    }


}
