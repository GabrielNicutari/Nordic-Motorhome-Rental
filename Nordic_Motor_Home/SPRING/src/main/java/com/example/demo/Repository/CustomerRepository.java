package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll() {
        String query = "SELECT c.id, c.firstName, c.lastName, c.address, c.zipCodeCustomer, z.city, c.phoneNumber," +
                "c.email, c.driverSinceDate, c.driverLicenceNumber FROM customers c, zip z " +
                "WHERE z.zipCode = c.zipCodeCustomer " +
                "ORDER BY c.id";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);

        return template.query(query, rowMapper);
    }

    public void add(Customer c) {
        if(!doesZipExist(c.getZipCodeCustomer())) {
            String query1 = "INSERT INTO zip (zipCode, city)" +
                    "VALUES (?, ?)";
            template.update(query1, c.getZipCodeCustomer(), c.getCity());
        }
        String query2 = "INSERT INTO customers (id, firstName, lastName, address, zipCodeCustomer, phoneNumber, email, " +
                "driverSinceDate, driverLicenceNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query2, c.getId(), c.getFirstName(), c.getLastName(), c.getAddress(), c.getZipCodeCustomer(),
                c.getPhoneNumber(), c.getEmail(),
                c.getDriverSinceDate(), c.getDriverLicenceNumber());
    }
  
    private boolean doesZipExist(String newZip) { // checks if the zip already exists in the zip table
        return template.queryForObject("SELECT EXISTS(SELECT zipCode FROM zip " +
                "WHERE zipCode = \"" + newZip + "\")", Boolean.class);
    }

    private boolean doesCityExist(String updatedCity, String zip) {
        return template.queryForObject("SELECT EXISTS(SELECT city FROM zip " +
                "WHERE city = \"" + updatedCity + "\")", Boolean.class);
    }

    public Boolean deleteRow(int id) {
        String query = "DELETE FROM customers WHERE id = ?";

        return template.update(query, id) < 0;
    }

    public List<Customer> findByKeyWord(String keyword) {
        String query = "SELECT * FROM customers WHERE firstName LIKE '%" + keyword + "%' " +
                "OR lastName LIKE '%" + keyword + "%' OR phoneNumber LIKE '%" + keyword + "%'";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);

        return template.query(query, rowMapper);
    }

    public Customer findById(int id) {
        String query = "SELECT c.id, c.firstName, c.lastName, c.address, c.zipCodeCustomer, z.city, c.phoneNumber, " +
                "c.email, c.driverSinceDate, c.driverLicenceNumber " +
                "FROM customers c " +
                "JOIN zip z " +
                "ON c.zipCodeCustomer = z.zipCode " +
                "WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(query, rowMapper, id);
    }

    public void update(Customer c, int id) {
        //If zip code is new in the db, it has to be stored in the zip table
        if(!doesZipExist(c.getZipCodeCustomer())) {
            String query1 = "INSERT INTO zip (zipCode, city) " +
                    "VALUES (?, ?)";
            template.update(query1, c.getZipCodeCustomer(), c.getCity());
        }
        if(!doesCityExist(c.getCity(), c.getZipCodeCustomer())) {
            String query2 = "UPDATE zip SET city = ? WHERE zipCode = ?";;
            template.update(query2, c.getCity(), c.getZipCodeCustomer());
        }

        String query3 = "UPDATE customers SET firstName = ?, lastName = ?, address = ?, zipCodeCustomer = ?," +
                    "phoneNumber = ?, email = ?, driverLicenceNumber = ?, driverSinceDate = '" + c.getDriverSinceDate() + "' WHERE id= ?";
        template.update(query3, c.getFirstName(), c.getLastName(), c.getAddress(), c.getZipCodeCustomer(),
                c.getPhoneNumber(), c.getEmail(), c.getDriverLicenceNumber(), id);
    }
} 