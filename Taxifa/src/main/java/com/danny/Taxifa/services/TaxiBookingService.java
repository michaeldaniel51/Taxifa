package com.danny.Taxifa.services;

import com.danny.Taxifa.annotations.LogExecutionTime;
import com.danny.Taxifa.entities.Taxi;
import com.danny.Taxifa.entities.TaxiBooking;
import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.exceptions.MoneyNotCompleteException;
import com.danny.Taxifa.repositories.TaxiBookingRepository;
import com.danny.Taxifa.repositories.TaxiRepository;
import com.danny.Taxifa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiBookingService {


    @Autowired
    private TaxiBookingRepository taxiBookingRepository;


    @LogExecutionTime
    public TaxiBooking book(TaxiBooking taxiBooking){

            return taxiBookingRepository.save(taxiBooking);

    }

    public List<TaxiBooking>taxiBookingList(){

        return taxiBookingRepository.findAll();

    }

//    public TaxiBooking findTaxiByUser(int id){
//        return taxiBookingRepository.findByUser(id);
//    }

    public void cancelBooking(int taxiBookingId){
        taxiBookingRepository.deleteById(taxiBookingId);

    }
    @LogExecutionTime
    public TaxiBooking editTaxiBookingInfo(TaxiBooking taxiBooking){

        return  taxiBookingRepository.save(taxiBooking);
    }





}
