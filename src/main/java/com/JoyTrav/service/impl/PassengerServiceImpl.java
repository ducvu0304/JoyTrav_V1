package com.JoyTrav.service.impl;

import com.JoyTrav.dto.PassengerDTO;
import com.JoyTrav.model.Booking;
import com.JoyTrav.model.Passenger;
import com.JoyTrav.repository.PassengerRepository;
import com.JoyTrav.service.PassengerService;
import com.JoyTrav.utils.ConvertObject;
import com.JoyTrav.utils.DateFormater;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private ConvertObject convertObject;

    @Autowired
    private DateFormater dateFormater;
    @Override
    public List<Passenger> fetchALl() {
        return null;
    }

    @Override
    public Optional<Passenger> getById(Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }

    @Override
    public void create(Passenger passenger) {

    }

    @Override
    public void save(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Passenger convertPassengerDTOToPassenger(PassengerDTO passengerDTO, Booking booking)  {
        Passenger passenger =  new Passenger();

        passenger.setId(idGenerator.generateID());
        passenger.setFullName(passengerDTO.getFullName());
        passenger.setGender(passengerDTO.getGender().equals("1"));
        passenger.setDob(dateFormater.coverToDate(passengerDTO.getDob()));
        passenger.setGroup(convertObject.convertToGroup(passengerDTO.getGroupAge()));
        passenger.setBooking(booking);

        return passenger;
    }
}
