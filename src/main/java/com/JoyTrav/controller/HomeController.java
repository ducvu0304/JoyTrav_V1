package com.JoyTrav.controller;

import com.JoyTrav.dto.OfferTour;
import com.JoyTrav.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @Autowired
    private TourService tourService;

    @RequestMapping({"/", "/home"} )
    public String home(Model model) {

        List<OfferTour> firstOffers = tourService.fetchFirstOffers();
        List<OfferTour> secondOffers = tourService.fetchSecondOffers();

        model.addAttribute("firstOffers", firstOffers);
        model.addAttribute("secondOffers", secondOffers);
        return "home";

    }



    @GetMapping("/hotel")
    public String hotelPage() {
        return "Hotel";
    }

    @GetMapping("/service")
    public String ServicePage() {
        return "Service";
    }
}
