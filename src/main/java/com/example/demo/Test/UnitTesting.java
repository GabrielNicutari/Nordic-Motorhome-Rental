package com.example.demo.Test;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.CustomerRepository;
import org.junit.Assert.*;
import org.junit.*;
import org.junit.Assert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UnitTesting {

    CustomerRepository customerRepo = new CustomerRepository();

    @Test
    public void test1() throws ParseException {

        //Parsing a value to date format to input into the constructor
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String d1String = "1990-12-12";
        java.util.Date d1 = format.parse(d1String);
        java.sql.Date sqlDate = new java.sql.Date(d1.getTime());

        //Creating a customer object and adding it to the database to test from.
        Customer c = new Customer(999, "Test", "Jensen", "Nyhavn 35", "2300", "Copenhagen",
                "23212345", "Test.jensen@gmail.com", sqlDate , "556545");

        //Testing
        Assert.assertEquals(999, c.getId());
        Assert.assertEquals("Test", c.getFirstName());
    }

    @Test
    public void test2() {

        //Creating a customer object and adding it to the database to test from.
        Employee c = new Employee(999, "Test", "Jensen", "Nyhavn 35", "2300", "Copenhagen", "23212345",
                "Test.jensen@gmail.com", "223232-1111", "Bossman", 99, 0.2);

        //Testing
        Assert.assertEquals(999, c.getId());
        Assert.assertEquals("Test", c.getFirstName());
    }
}

