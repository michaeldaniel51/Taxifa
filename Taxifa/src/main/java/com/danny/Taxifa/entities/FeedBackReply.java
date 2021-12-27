package com.danny.Taxifa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class FeedBackReply {

    @Id
    @GeneratedValue
    private int id;
    private String message;
    @ManyToOne
    private FeedBack feedBack;
    @ManyToOne
    private User user;
    private LocalDateTime timeOfReply=LocalDateTime.now();

    public FeedBackReply(int id, String message, FeedBack feedBack, User user, LocalDateTime timeOfReply) {
        this.id = id;
        this.message = message;
        this.feedBack = feedBack;
        this.user = user;
        this.timeOfReply = timeOfReply;
    }

    public FeedBackReply() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }

    public LocalDateTime getTimeOfReply() {
        return timeOfReply;
    }

    public void setTimeOfReply(LocalDateTime timeOfReply) {
        this.timeOfReply = timeOfReply;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FeedBackReply{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", feedBack=" + feedBack +
                ", user=" + user +
                ", timeOfReply=" + timeOfReply +
                '}';
    }
}
