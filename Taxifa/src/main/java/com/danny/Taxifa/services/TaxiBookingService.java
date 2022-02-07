package com.danny.taxifa.services;

import com.danny.taxifa.annotations.ShowExecutionTime;
import com.danny.taxifa.entities.TaxiBooking;
import com.danny.taxifa.repositories.TaxiBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiBookingService {


    @Autowired
    private TaxiBookingRepository taxiBookingRepository;


    @ShowExecutionTime
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
    @ShowExecutionTime
    public TaxiBooking editTaxiBookingInfo(TaxiBooking taxiBooking){

        return  taxiBookingRepository.save(taxiBooking);
    }





}
