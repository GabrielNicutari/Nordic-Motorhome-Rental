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

    public List<Customer> fetch() {
        return customerRepository.fetch();
    }
  
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    public Customer getOne(int id) {
        return customerRepository.findById(id);
    }

    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    public void update(Customer customer, int id) {
        customerRepository.update(customer, id);
    }

    //Get customers by keyword
    public List<Customer> findByKeyword(String keyword) {
        return customerRepository.findByKeyword(keyword);
    }
}
