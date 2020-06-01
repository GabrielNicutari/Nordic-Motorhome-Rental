package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate template;

    //Display
    public List<Employee> fetchAll() {
        String query = "SELECT e.id, e.firstName, e.lastName, e.address, e.zipCodeEmployee, zip.city, e.phoneNumber, e.email, e.cpr, e.role, " +
                "e.hoursPerWeek, e.wage " +
                "FROM employees e " +
                "JOIN zip " +
                "ON e.zipCodeEmployee = zip.zipCode";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(query, rowMapper);
    }

    public List<Employee> findByKeyWord(String keyword) {  //only first name and last name
        String query = "SELECT e.id, e.firstName, e.lastName, e.address, e.zipCodeEmployee, zip.city, e.phoneNumber, e.email, e.cpr, e.role," +
                "e.hoursPerWeek, e.wage " +
                " FROM employees e " +
                "JOIN zip " +
                "ON e.zipCodeEmployee = zip.zipCode " +
                "WHERE e.firstName LIKE '%" + keyword + "%' OR e.lastName LIKE '%" + keyword + "%' OR e.cpr LIKE '" + keyword +
                "%' OR e.phoneNumber LIKE '" + keyword + "%'";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(query, rowMapper);
    }

    //Create
    public void add(Employee employee) {

        if(!doesZipEmployeeExist(employee.getZipCodeEmployee())) {
            String query = "INSERT INTO zip (zipCode, city)" +
                    "VALUES (?, ?)";
            template.update(query, employee.getZipCodeEmployee(), employee.getCity());
        }

        String query = "INSERT INTO employees (id, firstName, lastName, address, zipCodeEmployee, phoneNumber, email, cpr, role,  hoursPerWeek, wage)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(), employee.getZipCodeEmployee(),
                 employee.getPhoneNumber(), employee.getEmail(), employee.getCpr(), employee.getRole(), employee.getHoursPerWeek(), employee.getWage());
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private boolean doesZipEmployeeExist(String newZip) {
        return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT zipCode FROM zip WHERE zipCode = \"" + newZip + "\")", Boolean.class);
    }

    private boolean doesCityExist(String updatedCity, String zip) {
        return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT city FROM zip WHERE city = \"" + updatedCity + "\")", Boolean.class);
    }

    //Update
    public void update(Employee employee, int id) {
        //If zip code is new in db, it has to be stored in zip table
            if(!doesZipEmployeeExist(employee.getZipCodeEmployee())) {
                String query = "INSERT INTO zip (zipCode, city) " +
                        "VALUES (?, ?)";
                template.update(query, employee.getZipCodeEmployee(), employee.getCity());
            }

            if(!doesCityExist(employee.getCity(), employee.getZipCodeEmployee())) {
                String query = "UPDATE zip SET city = ? WHERE zipCode = ?";
                template.update(query, employee.getCity(), employee.getZipCodeEmployee());
            }

            String query = "UPDATE employees SET firstName = ?, lastName = ?, address = ?, zipCodeEmployee = ?, phoneNumber = ?, email = ?, cpr = ?, " +
                    "role = ?, hoursPerWeek = ?, wage = ? WHERE id= ?";
            template.update(query, employee.getFirstName(), employee.getLastName(), employee.getAddress(), employee.getZipCodeEmployee(),
                    employee.getPhoneNumber(), employee.getEmail(), employee.getCpr(),employee.getRole(), employee.getHoursPerWeek(), employee.getWage(), id);
    }

    public Employee findById(int id) {
        String query = "SELECT e.id, e.firstName, e.lastName, e.address, e.zipCodeEmployee, zip.city, e.phoneNumber, e.email, e.cpr, e.role," +
                " e.hoursPerWeek, e.wage FROM employees e " +
                "JOIN zip " +
                    "ON e.zipCodeEmployee = zipCode " +
                "WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.queryForObject(query, rowMapper, id);
    }

    //Delete
    public void deleteRow(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        template.update(query, id);
    }
}
