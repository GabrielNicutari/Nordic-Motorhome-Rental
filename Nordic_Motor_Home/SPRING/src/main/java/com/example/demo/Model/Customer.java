package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Customer extends Person{

    @Id
    private int id;
    private String zipCodeCustomer;
    private String city;
    private Date driverSinceDate;
    private String driverLicenceNumber;

    //Only for the RentalContract dropdown
    private String fullName;

    public Customer() {
        super();
    }

    public Customer(int id, String firstName, String lastName, String address, String phoneNumber, String email,
                    Date driverSinceDate, String driverLicenceNumber, String fullName) {
        super (firstName, lastName, address, phoneNumber, email);
        this.id = id;
        this.driverSinceDate = driverSinceDate;
        this.driverLicenceNumber = driverLicenceNumber;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZipCodeCustomer() {
        return zipCodeCustomer;
    }

    public void setZipCodeCustomer(String zipCodeCustomer) {
        this.zipCodeCustomer = zipCodeCustomer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public Date getDriverSinceDate() {
        return driverSinceDate;
    }

    public void setDriverSinceDate(Date driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
