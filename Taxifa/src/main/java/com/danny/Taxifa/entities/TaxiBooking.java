package com.danny.Taxifa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.repository.query.parser.Part;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class TaxiBooking {


    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User passenger;
    @ManyToOne
    private Taxi taxi;
    @ManyToOne
    private Driver driver;
    private LocalDateTime timeOfBooking = LocalDateTime.now();

    public TaxiBooking(int id, User passenger, Taxi taxi, Driver driver, LocalDateTime timeOfBooking) {
        this.id = id;
        this.passenger = passenger;
        this.taxi = taxi;
        this.driver = driver;
        this.timeOfBooking = timeOfBooking;
    }

    public TaxiBooking() {
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public User getPassenger() {
        return passenger;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }



    public LocalDateTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalDateTime timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }


    @Override
    public String toString() {
        return "TaxiBooking{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", taxi=" + taxi +
                ", driver=" + driver +
                ", timeOfBooking=" + timeOfBooking +
                '}';
    }
}