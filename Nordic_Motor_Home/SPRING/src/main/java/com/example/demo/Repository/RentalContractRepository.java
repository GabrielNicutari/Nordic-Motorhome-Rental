package com.example.demo.Repository;

import com.example.demo.Model.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalContractRepository {

    @Autowired
    JdbcTemplate template;

    public List<RentalContract> fetchAll() {
        String query = "SELECT rentalcontracts.*, motorhomes.plate FROM rentalcontracts, motorhomes";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.query(query, rowMapper);
    }

    public void add(RentalContract rc) {
        String query = "INSERT INTO rentalcontracts (customerId, motorhomeId, accessoryId, season, fromDate, toDate, fuel, extraKm, pickUpLocation, dropOffLocation, " +
                "rentalprice, postRentalPrice, totalPrice, status)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, rc.getCustomerId(), rc.getMotorhomeId(), rc.getAccessoryId(), rc.getSeason(), rc.getFromDate(),
                rc.getToDate(), rc.getFuel(), rc.getExtraKm(), rc.getPickUpLocation(), rc.getDropOffLocation(), rc.getRentalPrice(), rc.getPostRentalPrice(),
                rc.getTotalPrice(), rc.getStatus());
    }

    public Boolean deleteRow(int id) {
        String query = "DELETE FROM rentalcontracts WHERE id = ?";
        return template.update(query, id) < 0;
    }

    public List<RentalContract> findByKeyWord(String keyword) {  //only plate now
        String query = "SELECT * FROM rentalcontracts WHERE customerId LIKE '%" + keyword + "%'";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.query(query, rowMapper);
    }

    public RentalContract findById(int id) {
        String query = "SELECT * FROM rentalcontracts WHERE id = ?";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.queryForObject(query, rowMapper, id);
    }

    public void update(RentalContract rc, int id) {
        String query = "UPDATE rentalcontracts SET customerId = ?, motorhomeId = ?, accessoryId = ?, season = ?, fromDate = ?, toDate = ?, fuel = ?, extraKm = ?, pickUpLocation = ?, dropOffLocation = ?," +
                "rentalprice = ?, postRentalPrice = ?, totalPrice = ?, status WHERE id = ?";
        template.update(query, rc.getCustomerId(), rc.getMotorhomeId(), rc.getAccessoryId(), rc.getSeason(), rc.getFromDate(),
                rc.getToDate(), rc.getFuel(), rc.getExtraKm(), rc.getPickUpLocation(), rc.getDropOffLocation(), rc.getRentalPrice(), rc.getPostRentalPrice(),
                rc.getTotalPrice(), rc.getStatus(), id);
    }
}