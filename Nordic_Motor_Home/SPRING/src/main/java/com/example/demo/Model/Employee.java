package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity

public class Employee extends Person {

    @Id
    private int id;
    private String zipCodeEmployee;
    private String city;
    private String cpr;
    private String role;
    private int hoursPerWeek;
    private double wage;

    public Employee() {super();}

    public Employee(int id, String firstName, String lastName, String address, String zipCodeEmployee, String city, String phoneNumber,
                    String email, String cpr, String role, int hoursPerWeek, double wage) {
        super(firstName, lastName, address, phoneNumber, email);
        this.id = id;
        this.zipCodeEmployee = zipCodeEmployee;
        this.city = city;
        this.cpr = cpr;
        this.role = role;
        this.wage = wage;
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public String getAddress() {
        return super.getAddress();
    }

    public String getZipCodeEmployee() {
        return zipCodeEmployee;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getCpr() {
        return cpr;
    }

    public String getRole() {
        return role;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public double getWage() {
        return wage;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", zip='" + zipCodeEmployee + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", cpr='" + cpr + '\'' +
                ", role='" + role + '\'' +
                ", hoursPerWeek=" + hoursPerWeek + '\'' +
                ", wage=" + wage +
                '}';
    }
}
