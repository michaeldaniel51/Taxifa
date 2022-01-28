package com.danny.Taxifa.controllers;


import com.danny.Taxifa.entities.FeedBackReply;
import com.danny.Taxifa.services.FeedBackReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbackreply")
public class FeedBackReplyController {

    @Autowired
    private FeedBackReplyService feedBackReplyService;

    @PostMapping
    public ResponseEntity<FeedBackReply> postAReply(@RequestBody FeedBackReply feedBackReply){
        return ResponseEntity.ok(feedBackReplyService.replyAFeedBack(feedBackReply));
    }

    @PutMapping
    public ResponseEntity<FeedBackReply> editAReply(@RequestBody FeedBackReply feedBackReply){
        return ResponseEntity.ok(feedBackReplyService.editReply(feedBackReply));
    }

    @DeleteMapping("/{id}")
    public void deleteRepliesId(@PathVariable int id){
        feedBackReplyService.deleteReplies(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedBackReply> findReplyById(@PathVariable int id){
        return ResponseEntity.ok(feedBackReplyService.findRepliesById(id));
    }

    @GetMapping
    public ResponseEntity<List<FeedBackReply>> getAllReplies(){
        return ResponseEntity.ok(feedBackReplyService.getAllFeedBackReplies());
    }





}
