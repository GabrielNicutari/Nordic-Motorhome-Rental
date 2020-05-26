package com.example.demo.Service;

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

    //List<Person> persons = new ArrayList<>();

    public List<RentalContract> fetchAll() {
        //personRepository.fetchAll().forEach(persons::add);  //Get everything from the db and add it into an arraylist
        return rentalContractRepository.fetchAll();
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
