package com.danny.taxifa.controllers;


import com.danny.taxifa.entities.Taxi;
import com.danny.taxifa.entities.User;
import com.danny.taxifa.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taxi")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;



    @PostMapping
    public ResponseEntity<?> addTaxi(@RequestBody Taxi taxi){
        return ResponseEntity.ok(taxiService.addTaxi(taxi));
    }


    @GetMapping
    public ResponseEntity<?> getAllTaxi(){
        return ResponseEntity.ok(taxiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(taxiService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTaxi(@PathVariable String id){
        taxiService.deleteTaxi(id);
    }

    @PutMapping
    public ResponseEntity<Taxi> updateTaxi(@RequestBody Taxi taxi){
      return ResponseEntity.accepted().body( taxiService.updateTaxi(taxi));
    }








}
