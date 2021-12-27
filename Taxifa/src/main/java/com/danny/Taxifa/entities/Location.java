package com.danny.Taxifa.entities;

import com.danny.Taxifa.enums.Destination;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@ToString
@Entity
public class Location {

    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private Destination from;
    @Enumerated(EnumType.STRING)
    private Destination to;
    private LocalTime departureTime;
    private LocalTime arrivalTime;


    public Location(long id, Destination from, Destination to, LocalTime departureTime, LocalTime arrivalTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Location() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Destination getFrom() {
        return from;
    }

    public void setFrom(Destination from) {
        this.from = from;
    }

    public Destination getTo() {
        return to;
    }

    public void setTo(Destination to) {
        this.to = to;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
      this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}







