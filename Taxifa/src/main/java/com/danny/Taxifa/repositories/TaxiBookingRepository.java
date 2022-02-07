package com.danny.taxifa.repositories;

import com.danny.taxifa.entities.TaxiBooking;
import com.danny.taxifa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiBookingRepository extends JpaRepository<TaxiBooking,Integer> {

//    TaxiBooking findByUser(int id);
//
//    TaxiBooking findByUser(User user);


}
