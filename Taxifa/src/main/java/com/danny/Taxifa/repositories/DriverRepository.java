package com.danny.taxifa.repositories;

import com.danny.taxifa.entities.Driver;
import com.danny.taxifa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository  extends JpaRepository<Driver,Integer> {

    List<Driver> findByProfile(User user);

}





