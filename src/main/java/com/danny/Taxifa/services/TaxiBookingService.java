package com.danny.Taxifa.services;

import com.danny.Taxifa.annotations.ShowExecutionTime;
import com.danny.Taxifa.entities.TaxiBooking;
import com.danny.Taxifa.repositories.TaxiBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiBookingService {


    @Autowired
    private TaxiBookingRepository taxiBookingRepository;

    @Autowired
    private SecurityService securityService;

    @ShowExecutionTime
    public TaxiBooking book(TaxiBooking taxiBooking){
        taxiBooking.setPassenger(securityService.authenticatedUser());
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
