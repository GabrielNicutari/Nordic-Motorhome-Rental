package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate template;

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
                "WHERE e.firstName LIKE '%" + keyword + "%' OR e.lastName LIKE %'" + keyword + "%'";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(query, rowMapper);
    }
//
//
//
//    public void add(Employee employee) {
//        String query = "INSERT INTO motorhomes (firstName, lastName, cpr, address, phoneNumber, email, role, wage, hoursPerWeek, )" +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        template.update(query, employee.getFirstName(), employee.getLastName(), employee.getCpr(), employee.getAddress(), employee.getPhoneNumber(),
//                employee.getEmail(), employee.getRole(), employee.getWage(), employee.getHoursPerWeek());
//    }
//
//    public void deleteRow(int id) {
//        String query = "DELETE FROM employees WHERE id = ?";
//        template.update(query, id);
//    }
//
//    public Employee findById(int id) {
//        String query = "SELECT * FROM employees WHERE id = ?";
//        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
//        return template.queryForObject(query, rowMapper, id);
//    }
//
//    public void update(Employee employee, int id) {
//        String query = "UPDATE employees SET firstName = ?, lastName = ?, cpr = ?, address = ?, phoneNumber = ?, email = ?, " +
//                "role = ?, wage = ?, hoursPerWeek = ? WHERE id= ?";
//        template.update(query, employee.getFirstName(), employee.getLastName(), employee.getCpr(), employee.getAddress(), employee.getPhoneNumber(),
//                employee.getEmail(), employee.getRole(), employee.getWage(), employee.getHoursPerWeek(), id);
//    }
}
