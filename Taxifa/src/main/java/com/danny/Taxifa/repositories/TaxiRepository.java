package com.danny.Taxifa.repositories;

import com.danny.Taxifa.entities.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxiRepository extends JpaRepository<Taxi,String> {
}
