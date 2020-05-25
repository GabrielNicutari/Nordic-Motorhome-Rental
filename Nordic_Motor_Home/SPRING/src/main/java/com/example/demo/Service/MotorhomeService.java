package com.example.demo.Service;

import com.example.demo.Model.Motorhome;
import com.example.demo.Repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {

    @Autowired
    private MotorhomeRepository motorhomeRepository;

    //List<Person> persons = new ArrayList<>();

    public List<Motorhome> fetchAll() {
        //personRepository.fetchAll().forEach(persons::add);  //Get everything from the db and add it into an arraylist
        return motorhomeRepository.fetchAll();
    }
  
    public void add(Motorhome g) {
       motorhomeRepository.add(g);
    }

    public Motorhome getOne(int id) {
        return motorhomeRepository.findById(id);
    }

    public boolean deleteRow(int id) {
        return motorhomeRepository.deleteRow(id);
    }

    public void update(Motorhome g, int id) {
        motorhomeRepository.update(g, id);
    }

    //Get motorhomes by keyword
    public List<Motorhome> findByKeyWord(String keyword) {
        return motorhomeRepository.findByKeyWord(keyword);
    }
}
