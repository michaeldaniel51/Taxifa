package com.danny.Taxifa.repositories;

import com.danny.Taxifa.entities.TaxiBooking;
import com.danny.Taxifa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiBookingRepository extends JpaRepository<TaxiBooking,Integer> {

//    TaxiBooking findByUser(int id);
//
//    TaxiBooking findByUser(User user);


}
