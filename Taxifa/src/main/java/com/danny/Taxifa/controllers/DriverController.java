package com.danny.taxifa.controllers;


import com.danny.taxifa.entities.Driver;
import com.danny.taxifa.entities.User;
import com.danny.taxifa.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping
    public ResponseEntity<?> createDriver(@RequestBody Driver driver){
        return ResponseEntity.ok(driverService.createDriver(driver));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDriverById(@PathVariable int id){
        return ResponseEntity.ok(driverService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllDriver(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id);
    }

    @PutMapping
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){

        return ResponseEntity.accepted().body(driverService.updateDriverInfo(driver));
    }

    @GetMapping("/profile")
    public ResponseEntity<List<Driver>> findDriverByprofile(@RequestParam int id){
        return ResponseEntity.ok(driverService.findDriverByUserProfile(id));

    }

}
