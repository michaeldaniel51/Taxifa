package com.danny.taxifa.entities;

import com.danny.taxifa.enums.TripType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;



@Entity
public class Driver {


    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User profile;
    @Enumerated(EnumType.STRING)
    private TripType tripType;


    public Driver(int id, User profile, TripType tripType) {
        this.id = id;
        this.profile = profile;
        this.tripType = tripType;
    }

    public Driver() {
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", profile=" + profile +
                ", tripType=" + tripType +
                '}';
    }
}
