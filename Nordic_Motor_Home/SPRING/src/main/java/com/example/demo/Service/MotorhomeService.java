package com.example.demo.Service;

import com.example.demo.Model.Brand;
import com.example.demo.Model.Model;
import com.example.demo.Model.Motorhome;
import com.example.demo.Repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {

    @Autowired
    private MotorhomeRepository motorhomeRepository;

    public List<Motorhome> fetchAll() {
        return motorhomeRepository.fetchAll();
    }

    public List<Brand> fetchBrands() {
        return motorhomeRepository.fetchBrands();
    }

    public List<Model> fetchModels() {
        return motorhomeRepository.fetchModels();
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

//    public void update(Motorhome g, int id) {
//        motorhomeRepository.update(g, id);
//    }

    //Get motorhomes by keyword
    public List<Motorhome> findByKeyWord(String keyword) {
        return motorhomeRepository.findByKeyWord(keyword);
    }



}
