package com.danny.Taxifa.services;


import com.danny.Taxifa.annotations.ShowExecutionTime;
import com.danny.Taxifa.entities.Driver;
import com.danny.Taxifa.exceptions.DriverNotFoundException;
import com.danny.Taxifa.exceptions.PassengerNotFoundException;
import com.danny.Taxifa.repositories.DriverRepository;
import com.danny.Taxifa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @ShowExecutionTime
    public Driver createDriver(Driver driver){

//        String message = driver.getProfile().getFirstname() + " Thanks for registering as a driver \n" +
//                " we will get back to you shortly";
        return driverRepository.save(driver);

    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public void deleteDriver(int id){
        driverRepository.deleteById(id);
    }

    public Driver findById(int id){
        return driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("driver not found"));

    }

    @ShowExecutionTime
    public Driver updateDriverInfo(Driver driver){
        return  driverRepository.save(driver);
    }

    @ShowExecutionTime
    public List<Driver> findDriverByUserProfile(int id){

        return driverRepository.findByProfile(userRepository
                .findById(id)
                .orElseThrow(()-> new PassengerNotFoundException("this passenger with id: " + id + " is not in the system")));

    }

}
