package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Motorhome;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> fetchAll() {
        return employeeRepository.fetchAll();
    }

    public List<Employee> findByKeyWord(String keyword) {
        return employeeRepository.findByKeyWord(keyword);
    }


    public void add(Employee employee) {
        employeeRepository.add(employee);
    }


    public void update(Employee employee, int id) {
        employeeRepository.update(employee, id);
    }

    public Employee getOne(int id) {
        return employeeRepository.findById(id);
    }


    public void deleteRow(int id) {
        employeeRepository.deleteRow(id);
    }


}