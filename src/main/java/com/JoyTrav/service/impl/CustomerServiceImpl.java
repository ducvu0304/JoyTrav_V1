package com.JoyTrav.service.impl;

import com.JoyTrav.dto.CustomerDTO;
import com.JoyTrav.model.Customer;
import com.JoyTrav.model.Tour;
import com.JoyTrav.repository.CustomerRepository;
import com.JoyTrav.service.CustomerService;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IdGenerator generator;

    @Override
    public List<Customer> fetchALl() {
        return null;
    }

    @Override
    public Optional<Customer> getById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void create(Customer customer) {
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Customer covertToCustomer(CustomerDTO customerDTO, Optional<Tour> tour) {
        Customer customer = new Customer();

        customer.setId(generator.generateID());
        customer.setFullName(customerDTO.getFullName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());

        tour.ifPresent(value -> customer.getTourList().add(value));

        return customer;
    }

    @Override
    public CustomerDTO covertToCustomerDTO (int customerId) {
        Optional<Customer> customer = getById(customerId);

        if(customer.isPresent()) {
            CustomerDTO customerDTO =  new CustomerDTO();
            customerDTO.setFullName(customer.get().getFullName());
            customerDTO.setAddress(customer.get().getAddress());
            customerDTO.setEmail(customer.get().getEmail());
            customerDTO.setPhoneNumber(customer.get().getPhone());

            return customerDTO;
        }


        return null;

    }
}
