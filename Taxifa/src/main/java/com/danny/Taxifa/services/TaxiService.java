package com.danny.Taxifa.services;

import com.danny.Taxifa.annotations.LogExecutionTime;
import com.danny.Taxifa.entities.Taxi;
import com.danny.Taxifa.repositories.TaxiRepository;
import com.danny.Taxifa.utils.TrackingIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;



    @LogExecutionTime
    public Taxi addTaxi(Taxi taxi){
        taxi.setTrackingId(TrackingIdUtils.trackingNo());
        return taxiRepository.save(taxi);

    }

    public void deleteTaxi(String taxiId){

        taxiRepository.deleteById(taxiId);
    }

    public List<Taxi> findAll(){

        return taxiRepository.findAll();
    }

    public Optional<Taxi> findById(String taxiId){
        return taxiRepository.findById(taxiId);
    }


    public List<Taxi> gf(){

        return (List<Taxi>) findAll().stream().filter(s-> s.getAmount()<2000);
    }



    @LogExecutionTime
    public Taxi updateTaxi(Taxi taxi){

      return  taxiRepository.save(taxi);
    }





}
