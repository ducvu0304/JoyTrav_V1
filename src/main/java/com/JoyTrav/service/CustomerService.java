package com.JoyTrav.service;

import com.JoyTrav.dto.CustomerDTO;
import com.JoyTrav.model.Account;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Tour;

import java.util.Optional;

public interface CustomerService extends IGenericService<Customer, Integer> {
    Customer covertToCustomer(CustomerDTO customerDTO, Optional<Tour> tour);
    CustomerDTO covertToCustomerDTO(int customerId);
}
