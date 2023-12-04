package com.JoyTrav.service;

import com.JoyTrav.dto.PassengerDTO;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Passenger;

import java.text.ParseException;

public interface PassengerService extends IGenericService<Passenger, Integer> {
    Passenger convertPassengerDTOToPassenger(PassengerDTO passengerDTO, Booking booking) ;
}
