package com.JoyTrav.controller;

import com.JoyTrav.dto.AccountDTO;
import com.JoyTrav.dto.OfferTour;
import com.JoyTrav.dto.SignInForm;
import com.JoyTrav.dto.SignUpForm;
import com.JoyTrav.model.Account;
import com.JoyTrav.model.Customer;
import com.JoyTrav.security.JwtService;
import com.JoyTrav.security.UserInfoDetails;
import com.JoyTrav.security.UserInfoService;
import com.JoyTrav.service.AccountService;
import com.JoyTrav.service.TourService;
import com.JoyTrav.validation.CheckEmailExistValidator;
import com.JoyTrav.validation.ConfirmPasswordValidator;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class  AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TourService tourService;

    @Autowired
    private ConfirmPasswordValidator confirmPasswordValidator;

    @Autowired
    private CheckEmailExistValidator emailExistValidator;

    @Autowired
    private AccountService accountService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    // Sign-In
    @GetMapping("/sign-in")
    public String displayLoginPage( Model model) {
        model.addAttribute("signInForm", new SignInForm());
        return "auth/login-page";
    }

    @PostMapping("/sign-in/processSignIn")
    public String authenticateAndGetToken(@ModelAttribute("signInForm") @Valid SignInForm signInForm,
                                          BindingResult result,
                                          Model model,
                                          HttpSession session) {
        if(result.hasErrors()) {
            return "auth/login-page";
        }

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword()));
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }



        if (authentication.isAuthenticated()) {
            UserInfoDetails userInfoDetails = (UserInfoDetails) authentication.getPrincipal();
            String auth = userInfoDetails.getAuthorities().stream().findFirst().get().toString();

            String email = userInfoDetails.getUsername();


            if(auth.equalsIgnoreCase("USER")) {
                Account account =  accountService.fetchAccountByEmail(email);
                session.setAttribute("email", account.getEmail());

                return "redirect:/home";
            }else {
                return "redirect:/admin";
            }
        } else {
            model.addAttribute("loginFailure", "Pass wrong!");
            return "auth/login-page";
        }
    }

    @RequestMapping(value = "/processLogout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/home";
    }



    // Sign-Up
    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("signupForm", new SignUpForm());
        return "auth/register-page";
    }

    @PostMapping(value = "/signup/processRegistration")
    public String registerUserAccount(
            @ModelAttribute("signupForm") @Valid SignUpForm signupForm,
            BindingResult result,
            Model model) {

        confirmPasswordValidator.validate(signupForm, result);
        emailExistValidator.validate(signupForm, result);

        if(result.hasErrors()) {
            return "auth/register-page";
        }

        List<OfferTour> firstOffers = tourService.fetchFirstOffers();
        List<OfferTour> secondOffers = tourService.fetchSecondOffers();

        model.addAttribute("firstOffers", firstOffers);
        model.addAttribute("secondOffers", secondOffers);

        accountService.registerNewUserAccount(signupForm);

        model.addAttribute("signupStatus", true);
        return "redirect:/home";
    }

}
