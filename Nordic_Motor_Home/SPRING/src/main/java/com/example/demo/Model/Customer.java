package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Customer extends Person{

    @Id
    private int customerId;
    private String driverLicenceNumber;
    private Date driverSinceDate;

    public Customer() {
        super();
    }

    public Customer(int id, String firstName, String lastName, String address, String phoneNumber, String email,
                    int customerId, String driverLicenceNumber, Date driverSinceDate) {
        super (id, firstName, lastName, address, phoneNumber, email);
        this.customerId = customerId;
        this.driverLicenceNumber = driverLicenceNumber;
        this.driverSinceDate = driverSinceDate;
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
}
