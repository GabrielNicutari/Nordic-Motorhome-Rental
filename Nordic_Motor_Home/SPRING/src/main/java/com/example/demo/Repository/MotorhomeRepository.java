package com.example.demo.Repository;

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
                "WHERE mh.modelId = m.id AND m.brandId = b.id";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(query, rowMapper);
    }

    public void add(Motorhome mh) {
        String query = "INSERT INTO motorhomes (modelId, hp, plate, seatNumber, seatsMaterial, cruiseControl, pricePerDay, availability)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, mh.getModelId(), mh.getHp(), mh.getPlate(), mh.getSeatNumber(), mh.getSeatsMaterial(),
                mh.getCruiseControl(), mh.getPricePerDay(), mh.getAvailability());
    }

    public Boolean deleteRow(int id) {
        String query = "DELETE FROM motorhomes WHERE id = ?";
        return template.update(query, id) < 0;
    }

    public List<Motorhome> findByKeyWord(String keyword) {  //only plate now
        String query = "SELECT * FROM motorhomes WHERE plate LIKE '%" + keyword + "%'";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(query, rowMapper);
    }

    public Motorhome findById(int id) {
        String query = "SELECT * FROM motorhomes WHERE id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.queryForObject(query, rowMapper, id);
    }

    public void update(Motorhome mh, int id) {
        String query = "UPDATE motorhomes SET modelId = ?, hp = ?, plate = ?, seatNumber = ?, seatsMaterial = ?, cruiseControl = ?, " +
                "pricePerDay = ?, availability = ? WHERE id= ?";
        template.update(query, mh.getModelId(), mh.getHp(), mh.getPlate(), mh.getSeatNumber(), mh.getSeatsMaterial(),
                mh.getCruiseControl(), mh.getPricePerDay(), mh.getAvailability(), id);
    }
}