package com.danny.taxifa.repositories;

import com.danny.taxifa.entities.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxiRepository extends JpaRepository<Taxi,String> {
}
