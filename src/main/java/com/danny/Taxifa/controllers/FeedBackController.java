package com.danny.Taxifa.controllers;

import com.danny.Taxifa.entities.FeedBack;
import com.danny.Taxifa.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping//("/passenger")
    public ResponseEntity<?> addFeedBackByPassenger(@RequestBody FeedBack feedBack){

        return ResponseEntity.ok(feedBackService.dropFeedBackByPassenger(feedBack));
    }

    @PostMapping("/driver")
    public ResponseEntity<?> addFeedBackByDriver(@RequestBody FeedBack feedBack){

        return ResponseEntity.ok(feedBackService.dropFeedBackByDriver(feedBack));
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<?> getFeedBackByPassenger(@PathVariable int id){
        return ResponseEntity.ok(feedBackService.findByUser(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedBackById(@PathVariable int id){
        return ResponseEntity.ok(feedBackService.findFeedBackById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllFeedBack(){
        return ResponseEntity.ok(feedBackService.getAllFeedBacks());
    }

    @DeleteMapping
    public void deleteFeedBack(int id){

        feedBackService.deleteFeedBack(id);

    }

}
