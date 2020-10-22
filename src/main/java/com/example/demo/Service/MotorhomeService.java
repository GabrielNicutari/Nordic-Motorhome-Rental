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
  
    public void add(Motorhome motorhome) {
       motorhomeRepository.add(motorhome);
    }

    public Motorhome getOne(int id) {
        return motorhomeRepository.findById(id);
    }

    public boolean delete(int id) {
        return motorhomeRepository.delete(id);
    }

    public void update(Motorhome motorhome, int id) {
        motorhomeRepository.update(motorhome, id);
    }

    //Get motorhomes by keyword
    public List<Motorhome> findByKeyword(String keyword) {
        return motorhomeRepository.findByKeyword(keyword);
    }



}
