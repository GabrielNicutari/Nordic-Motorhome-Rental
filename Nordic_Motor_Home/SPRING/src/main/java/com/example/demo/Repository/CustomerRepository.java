package com.example.demo.Repository;

import com.example.demo.Model.Customer;
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
        String query1 = "INSERT INTO zip(zipCode, city) VALUES (?, ?)";
        String query2 = "INSERT INTO customers (id, firstName, lastName, address, zipCodeCustomer, phoneNumber, email, " +
                "driverSinceDate, driverLicenceNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        template.update(query1, c.getZipCodeCustomer(), c.getCity());
        template.update(query2, c.getId(), c.getFirstName(), c.getLastName(), c.getAddress(), c.getZipCodeCustomer(),
                c.getPhoneNumber(), c.getEmail(),
                c.getDriverSinceDate(), c.getDriverLicenceNumber());
    }

    public Boolean deleteRow(int id) {
        String query = "DELETE FROM customers WHERE id = ?";

        return template.update(query, id) < 0;
    }

    public List<Customer> findByKeyWord(String keyword) {  //only name now
        String query = "SELECT * FROM customers WHERE firstName LIKE '%" + keyword + "%'";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);

        return template.query(query, rowMapper);
    }

    public Customer findById(int id) {
        String query = "SELECT * FROM customers WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);

        return template.queryForObject(query, rowMapper, id);
    }

    public void update(Customer c, int id) {
        String query2 = "UPDATE customers SET firstName = ?, lastName = ?, address = ?, zipCodeCustomer = ?" +
                " phoneNumber = ?, email = ?, driverLicenceNumber = ?, driverSinceDate = ? WHERE id= ?";

        template.update(query2, c.getFirstName(), c.getLastName(), c.getAddress(), c.getZipCodeCustomer(),
                c.getPhoneNumber(), c.getEmail(), c.getDriverLicenceNumber(), c.getDriverSinceDate(), id);
    }
}