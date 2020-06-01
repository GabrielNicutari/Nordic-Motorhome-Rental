package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

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
    private String newPickUpLocation;
    private String newDropOffLocation;
    private int dropOffLocation;
    private double rentalPrice;
    private double postRentalPrice;
    private double totalPrice;
    private String status;

    //Fields we use from motorhome
    private String brand;
    private String model;
    private String plate;
    private String budget;
    private String size;
    private String cruiseControl;
    private int hp;
    private int seatNumber;
    private String seatMaterial;
    private double pricePerDay;

    //Fields we use from customer
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String city;
    private String phoneNumber;
    private String email;
    private Date driverSinceDate;
    private String driverLicenceNumber;

    public RentalContract() {}

    public RentalContract(int id, int customerId, int motorhomeId, int accessoryId, String season, String fromDate, String toDate, String fuel,
                          double extraKm, int pickUpLocation, int dropOffLocation, double rentalPrice, double postRentalPrice,
                          double totalPrice, String status, String brand, String model, String plate, String budget, String size, String cruiseControl,
                          int hp, int seatNumber, String seatMaterial, double pricePerDay, String firstName, String lastName, String address,
                          String zipCode, String city, String phoneNumber, String email, Date driverSinceDate, String driverLicenceNumber,
                          String newPickUpLocation, String newDropOffLocation) {
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

        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.budget = budget;
        this.size = size;
        this.cruiseControl = cruiseControl;
        this.hp = hp;
        this.seatNumber = seatNumber;
        this.seatMaterial = seatMaterial;
        this.pricePerDay = pricePerDay;

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.driverSinceDate = driverSinceDate;
        this.driverLicenceNumber = driverLicenceNumber;

        this.newPickUpLocation = newPickUpLocation;
        this.newDropOffLocation = newDropOffLocation;
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

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(String seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDriverSinceDate() {
        return driverSinceDate;
    }

    public void setDriverSinceDate(Date driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public String getNewPickUpLocation() {
        return newPickUpLocation;
    }

    public void setNewPickUpLocation(String newPickUpLocation) {
        this.newPickUpLocation = newPickUpLocation;
    }

    public String getNewDropOffLocation() {
        return newDropOffLocation;
    }

    public void setNewDropOffLocation(String newDropOffLocation) {
        this.newDropOffLocation = newDropOffLocation;
    }
}
