package com.danny.Taxifa.repositories;

import com.danny.Taxifa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  //  List<User> findByTypeOfUser(TypeOfUser typeOfUser);

    List<User> findByFirstname(String firstname);

    List<User> findByFirstnameAndLastname(String firstname ,String lastname);

    List<User> findByFirstnameOrLastname(String firstname,String lastname);

    Optional<User> findByUsername(String username);
}
