package com.example.demo.Model;

import javax.persistence.*;

@Entity
public class Motorhome {

    @Id
    private int id;
    private int modelId;
    private int hp;
    private String plate;
    private int seatNumber;
    private String seatsMaterial;
    private String cruiseControl;
    private double pricePerDay;
    private String availability;

    public Motorhome() {}

    public Motorhome(int id, int modelId, int hp, String plate, int seatNumber, String seatsMaterial, String cruiseControl,
                     double pricePerDay, String availability) {
        this.id = id;
        this.modelId = modelId;
        this.hp = hp;
        this.plate = plate;
        this.seatNumber = seatNumber;
        this.seatsMaterial = seatsMaterial;
        this.cruiseControl = cruiseControl;
        this.pricePerDay = pricePerDay;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatsMaterial() {
        return seatsMaterial;
    }

    public void setSeatsMaterial(String seatsMaterial) {
        this.seatsMaterial = seatsMaterial;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
