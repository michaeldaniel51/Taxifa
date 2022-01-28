package com.danny.Taxifa.services;

import com.danny.Taxifa.entities.FeedBack;
import com.danny.Taxifa.repositories.FeedBackRepository;
import com.danny.Taxifa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {


    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private UserRepository userRepository;


    public FeedBack dropFeedBackByPassenger(FeedBack feedBack){

        return feedBackRepository.save(feedBack);

    }

    public FeedBack dropFeedBackByDriver(FeedBack feedBack){

        return feedBackRepository.save(feedBack);

    }

    public List<FeedBack> getAllFeedBacks(){
        return  feedBackRepository.findAll();
    }

    public FeedBack findFeedBackById(int id){

        return feedBackRepository.findById(id).orElseThrow();

    }

    public List<FeedBack> findByUser(int id){
        return feedBackRepository.findByUser(userRepository.findById(id).orElseThrow());

    }

    public void deleteFeedBack(int id){
        feedBackRepository.deleteById(id);
    }

}
