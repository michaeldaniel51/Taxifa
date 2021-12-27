package com.danny.Taxifa.controllers;

import com.danny.Taxifa.entities.TaxiBooking;
import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.services.TaxiBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taxiBooking")
public class TaxiBookingController {

    @Autowired
    private TaxiBookingService taxiBookingService;



    @PostMapping
    public ResponseEntity<?> book_a_taxi(@RequestBody TaxiBooking taxiBooking){
        return ResponseEntity.ok(taxiBookingService.book(taxiBooking));
    }

    @GetMapping
    public ResponseEntity<?> taxiBookingList(){
        return ResponseEntity.ok(taxiBookingService.taxiBookingList());
    }

    @DeleteMapping("/{taxiBookingId}")
    public void cancelBooking(@PathVariable int taxiBookingId){
        taxiBookingService.cancelBooking(taxiBookingId);
    }
    @PutMapping
    public ResponseEntity<TaxiBooking> updateBookingInfo(@RequestBody TaxiBooking taxiBooking){

      return ResponseEntity.accepted().body(taxiBookingService.editTaxiBookingInfo(taxiBooking));
    }







}
