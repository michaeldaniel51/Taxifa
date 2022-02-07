package com.danny.taxifa.repositories;

import com.danny.taxifa.entities.FeedBack;
import com.danny.taxifa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Integer> {

    List<FeedBack> findByUser(User user);

}
