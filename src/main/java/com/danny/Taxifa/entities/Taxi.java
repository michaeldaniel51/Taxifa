package com.danny.Taxifa.entities;


import com.danny.Taxifa.enums.CarType;
import com.danny.Taxifa.enums.Departures;
import com.danny.Taxifa.enums.TaxiColor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Taxi {


    @Id
    private String trackingId;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    @Enumerated(EnumType.STRING)
    private TaxiColor taxiColor;
    private long amount;
    @Enumerated(EnumType.STRING)
    private Departures departures;



    public Taxi(String trackingId, CarType carType, TaxiColor taxiColor, long amount, Departures departures) {
        this.trackingId = trackingId;
        this.carType = carType;
        this.taxiColor = taxiColor;
        this.amount = amount;
        this.departures = departures;
    }

    public Taxi() {
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public TaxiColor getTaxiColor() {
        return taxiColor;
    }

    public void setTaxiColor(TaxiColor taxiColor) {
        this.taxiColor = taxiColor;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


    public Departures getDepartures() {
        return departures;
    }

    public void setDepartures(Departures departures) {
        this.departures = departures;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "trackingId='" + trackingId + '\'' +
                ", carType=" + carType +
                ", taxiColor=" + taxiColor +
                ", amount=" + amount +
                ", departures=" + departures +
                '}';
    }
}

