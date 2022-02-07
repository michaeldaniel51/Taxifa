package com.danny.taxifa.entities;

import com.danny.taxifa.enums.Rating;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue
    private int id;
    private String message;
    @Enumerated(EnumType.STRING)
    private Rating ratings;
    @ManyToOne
   // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private User user;
    private LocalDateTime timeOfFeedback = LocalDateTime.now();


    public FeedBack(int id, String message, Rating ratings, User user, LocalDateTime timeOfFeedback) {
        this.id = id;
        this.message = message;
        this.ratings = ratings;
        this.user = user;
        this.timeOfFeedback = timeOfFeedback;
    }

    public FeedBack() {
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

    public Rating getRatings() {
        return ratings;
    }

    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimeOfFeedback() {
        return timeOfFeedback;
    }

    public void setTimeOfFeedback(LocalDateTime timeOfFeedback) {
        this.timeOfFeedback = timeOfFeedback;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", ratings=" + ratings +
                ", user=" + user +
                ", timeOfFeedback=" + timeOfFeedback +
                '}';
    }
}
