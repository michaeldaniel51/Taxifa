package com.danny.Taxifa.controllers;

import com.danny.Taxifa.entities.Location;
import com.danny.Taxifa.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> addNewLocation(@RequestBody Location location){

        return ResponseEntity.ok(locationService.createLocation(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable long id){

        return ResponseEntity.ok(locationService.deleteLocationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Location> findLocationsById(@PathVariable long id){
        return ResponseEntity.ok(locationService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody Location location){
        return ResponseEntity.ok(locationService.UpdateLocation(location));
    }

}
