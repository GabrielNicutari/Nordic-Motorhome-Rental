package com.example.demo.Repository;

import com.example.demo.Model.Brand;
import com.example.demo.Model.Model;
import com.example.demo.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepository {

    @Autowired
    JdbcTemplate template;

    public List<Motorhome> fetchAll() {
        String query = "SELECT mh.id, b.brand, m.model, m.budget, m.size, m.fuelType, mh.hp, mh.plate, mh.seatNumber, " +
                " mh.seatNumber, mh.seatsMaterial, mh.cruiseControl, mh.pricePerDay, mh.availability FROM motorhomes mh, models m, brands b " +
                "WHERE mh.modelId = m.id AND m.brandId = b.id ORDER BY mh.id";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(query, rowMapper);
    }

    public List<Brand> fetchBrands() {
        String query = "SELECT b.id, b.brand FROM brands b";
        RowMapper<Brand> rowMapper = new BeanPropertyRowMapper<>(Brand.class);
        return template.query(query, rowMapper);
    }

    public List<Model> fetchModels() {
        String query = "SELECT m.id, m.model FROM models m";
        RowMapper<Model> rowMapper = new BeanPropertyRowMapper<>(Model.class);
        return template.query(query, rowMapper);
    }

    public void add(Motorhome mh) {
        String selectModelId = "SELECT m.id FROM models m where m.model = '" + mh.getModel() + "'";
        int modelId = template.queryForObject(selectModelId, int.class);

        String query = "INSERT INTO motorhomes (modelId, hp, plate, seatNumber, seatsMaterial, cruiseControl, pricePerDay, availability)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, modelId, mh.getHp(), mh.getPlate(), mh.getSeatNumber(), mh.getSeatsMaterial(),
                mh.getCruiseControl(), mh.getPricePerDay(), mh.getAvailability());
    }

    public Boolean delete(int id) {
        String query = "DELETE FROM motorhomes WHERE id = ?";
        return template.update(query, id) < 0;
    }

    public List<Motorhome> findByKeyword(String keyword) {
        String query = "SELECT mh.*, b.brand, m.model, m.budget, m.size, m.fuelType FROM motorhomes mh, brands b, models m WHERE (plate LIKE '%" + keyword + "%' " +
                "OR b.brand LIKE '%" + keyword + "%' OR m.model LIKE '%" + keyword + "%') AND mh.modelId = m.id AND m.brandId = b.id";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(query, rowMapper);
    }

    public Motorhome findById(int id) {
        String query = "SELECT mh.*, b.brand, m.model FROM motorhomes mh, brands b, models m WHERE mh.modelId = m.id AND m.brandId = b.id AND mh.id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.queryForObject(query, rowMapper, id);
    }

    public void update(Motorhome mh, int id) {
        String selectModelId = "SELECT m.id FROM models m where m.model = '" + mh.getModel() + "'";
        int modelId = template.queryForObject(selectModelId, int.class);

        String query = "UPDATE motorhomes SET modelId = ?, hp = ?, plate = ?, seatNumber = ?, seatsMaterial = ?, cruiseControl = ?, " +
                "pricePerDay = ?, availability = ? WHERE id= ?";
        template.update(query, modelId, mh.getHp(), mh.getPlate(), mh.getSeatNumber(), mh.getSeatsMaterial(),
                mh.getCruiseControl(), mh.getPricePerDay(), mh.getAvailability(), id);
    }
}