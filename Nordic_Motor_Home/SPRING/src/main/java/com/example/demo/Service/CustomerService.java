package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //List<Person> persons = new ArrayList<>();

    public List<Customer> fetchAll() {
        //personRepository.fetchAll().forEach(persons::add);  //Get everything from the db and add it into an arraylist
        return customerRepository.fetchAll();
    }
  
//    public void add(Customer c) {
//       customerRepository.add(c);
//    }

    public Customer getOne(int id) {
        return customerRepository.findById(id);
    }

    public boolean deleteRow(int id) {
        return customerRepository.deleteRow(id);
    }

    public void update(Customer c, int id) {
        customerRepository.update(c, id);
    }

    //Get customers by keyword
    public List<Customer> findByKeyWord(String keyword) {
        return customerRepository.findByKeyWord(keyword);
    }
}
