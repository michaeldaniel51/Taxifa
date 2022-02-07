package com.danny.taxifa.services;

import com.danny.taxifa.annotations.ShowExecutionTime;
import com.danny.taxifa.entities.Location;
import com.danny.taxifa.repositories.LocationRepository;
import com.danny.taxifa.utils.DestinationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @ShowExecutionTime
    public Location createLocation(Location location){

        location.setArrivalTime(DestinationUtils.arrivalTime());
        location.setDepartureTime(DestinationUtils.departureTime());
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations(){
        return new ArrayList<>(locationRepository.findAll());
    }

    public Location findById(long id){
     return  locationRepository.findById(id).orElseThrow();
    }


    public String deleteLocationById(long id){
        locationRepository.deleteById(id);
        return "Location with " + id + " has been deleted successfully";

    }
    @ShowExecutionTime
    public Location UpdateLocation(Location location){
        return locationRepository.save(location);
    }

}
