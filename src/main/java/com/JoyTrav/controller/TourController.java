package com.JoyTrav.controller;

import com.JoyTrav.dto.*;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Group;
import com.JoyTrav.model.Tour;
import com.JoyTrav.service.BookingService;
import com.JoyTrav.service.CustomerService;
import com.JoyTrav.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TourController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TourService tourService;

    @GetMapping("/tour")
    public String tourPage(Model model) {
        Pagination<Tour> pagination = tourService.findPage(1);
        System.out.println("cur: " + pagination.getCurrentPage());

        if(!pagination.getList().isEmpty()) {
            model.addAttribute("tourList", pagination.getList());
            model.addAttribute("pageNumbers", pagination.getPageNumbers());
            model.addAttribute("curPage", pagination.getCurrentPage());
        }

        return "tour";
    }

    @GetMapping("/tour/page={page}")
    public String findPage(@PathVariable int page, Model model) {

        Pagination<Tour> pagination = tourService.findPage(page);

        if(!pagination.getList().isEmpty()) {
            model.addAttribute("tourList", pagination.getList());
            model.addAttribute("pageNumbers", pagination.getPageNumbers());
            model.addAttribute("curPage", pagination.getCurrentPage());
        }

        return "tour";
    }

    @GetMapping("/tour/tourName={id}")
    public String viewTourDetail(@PathVariable String id, Model model) {
        Optional<Tour> tour = tourService.getById(id);

        if(tour.isPresent()) {
            TourDetail tourDetail = tourService.convertToTourDetail(tour.get());
            model.addAttribute("tourDetail", tourDetail);
            return "tour-details";
        }else {
            return "redirect:/tour";
        }
    }

    @GetMapping("/booking-detail/tourId={tourID}")
    public String viewBookingDetail(@PathVariable("tourID") String tourId, Model model) {
        Optional<Tour> optionalTour = tourService.getById(tourId);

        if(optionalTour.isPresent()) {
            model.addAttribute("tour", optionalTour.get());
            return "booking-details";
        }

        return "booking-details";
    }

    @GetMapping("/tour/tourName={id}/booking")
    public String viewBookingPage(@PathVariable String id, Model model) {
        Optional<Tour> tour = tourService.getById(id);

        model.addAttribute("customer", new Customer());

        if(tour.isPresent()) {
            model.addAttribute("tour", tour.get());
            return "tour-details";
        }else {
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


        if(customerDTO != null) {
            model.addAttribute("customerInfo", customerDTO);
        }


        Optional<Booking> booking = bookingService.getById(bookingId);

        if(booking.isPresent()) {
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

        BookingSummary bookingSummary =  new BookingSummary();

        TourDTO tourDTO =  tourService.covertToTourDTO(tourId);

        if (tourDTO != null) {
            bookingSummary.setTourDTO(tourDTO);
            bookingSummary.setTotal(booking.get().getTotal());
            bookingSummary.setAdultsNumber(adultsNumber);
            bookingSummary.setChildrenNumber(childrenNumber);
            bookingSummary.setChildrenNumber(infantsNumber);
            bookingSummary.setToddlersNumber(toddlersNumber);
        };

        model.addAttribute("bookingSummary", bookingSummary);

        return "payment";
    }

    @GetMapping("/payment/process-payment/bookingId={bookingId}")
    public String  processPayment(@PathVariable String bookingId,
                                       Model model) {
        Optional<Booking> booking = bookingService.getById(bookingId);

        if(booking.isPresent()) {
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
