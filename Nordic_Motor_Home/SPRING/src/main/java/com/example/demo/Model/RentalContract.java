package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalContract {

    @Id
    private int id;
    private int customerId;
    private int motorhomeId;
    private int accessoryId;
    private String season;
    private String fromDate;
    private String toDate;
    private String fuel;
    private double extraKm;
    private int pickUpLocation;
    private int dropOffLocation;
    private double rentalPrice;
    private double postRentalPrice;
    private double totalPrice;
    private String status;
    private String plate;

    public RentalContract() {}

    public RentalContract(int id, int customerId, int motorHomeId, String season, String fromDate, String toDate, String fuel, double extraKm, int pickUpLocation, int dropOffLocation, double rentalPrice, double postRentalPrice, double totalPrice, String status, String plate) {
        this.id = id;
        this.customerId = customerId;
        this.motorhomeId = motorhomeId;
        this.accessoryId = accessoryId;
        this.season = season;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fuel = fuel;
        this.extraKm = extraKm;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.rentalPrice = rentalPrice;
        this.postRentalPrice = postRentalPrice;
        this.totalPrice = totalPrice;
        this.status = status;
        this.plate = plate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorHomeId) {
        this.motorhomeId = motorHomeId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getExtraKm() {
        return extraKm;
    }

    public void setExtraKm(double extraKm) {
        this.extraKm = extraKm;
    }

    public int getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(int pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public int getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(int dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getPostRentalPrice() {
        return postRentalPrice;
    }

    public void setPostRentalPrice(double postRentalPrice) {
        this.postRentalPrice = postRentalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
