package com.example.demo.Service;

import com.example.demo.Model.Accessory;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Motorhome;
import com.example.demo.Model.RentalContract;
import com.example.demo.Repository.RentalContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContractService {

    @Autowired
    private RentalContractRepository rentalContractRepository;

    public List<RentalContract> fetchAll() {
        return rentalContractRepository.fetchAll();
    }

    public List<Customer> fetchCustomers() {
        return rentalContractRepository.fetchCustomers();
    }

    public List<Motorhome> fetchMotorhomes() {
        return rentalContractRepository.fetchMotorhomes();
    }

    public List<Accessory> fetchAccessories() {
        return rentalContractRepository.fetchAccessories();
    }
  
    public void add(RentalContract g) {
        rentalContractRepository.add(g);
    }

    public RentalContract getOne(int id) {
        return rentalContractRepository.findById(id);
    }

    public boolean deleteRow(int id) {
        return rentalContractRepository.deleteRow(id);
    }

    public void update(RentalContract g, int id) {
        rentalContractRepository.update(g, id);
    }

    //Get rental Contract by keyword
    public List<RentalContract> findByKeyWord(String keyword) {
        return rentalContractRepository.findByKeyWord(keyword);
    }
}
