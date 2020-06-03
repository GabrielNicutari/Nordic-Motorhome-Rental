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
  
    public void add(RentalContract rentalContract) {
        rentalContractRepository.add(rentalContract);
    }

    public RentalContract getOne(int id) {
        return rentalContractRepository.findById(id);
    }

    public boolean delete(int id) {
        return rentalContractRepository.delete(id);
    }

    public void update(RentalContract rc, int id) {
        rentalContractRepository.update(rc, id);
    }

    //Get rental Contract by keyword
    public List<RentalContract> findByKeyword(String keyword) {
        return rentalContractRepository.findByKeyword(keyword);
    }



    public String findPickUpLocationName(int id) {
        return rentalContractRepository.findPickUpLocationName(id);
    }

    public String findDropOffLocationName(int id) {
        return rentalContractRepository.findDropOffLocationName(id);
    }
}
