package com.JoyTrav.repository;

import com.JoyTrav.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("passengerRepository")
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
