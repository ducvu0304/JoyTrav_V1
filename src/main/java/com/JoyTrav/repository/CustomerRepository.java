package com.JoyTrav.repository;

import com.JoyTrav.dto.PassengerDTO;
import com.JoyTrav.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
