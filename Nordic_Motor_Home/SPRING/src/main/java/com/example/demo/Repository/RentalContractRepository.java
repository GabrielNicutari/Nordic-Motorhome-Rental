package com.example.demo.Repository;

import com.example.demo.Model.Accessory;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Motorhome;
import com.example.demo.Model.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

@Repository
public class RentalContractRepository {

    @Autowired
    JdbcTemplate template;

    public List<RentalContract> fetchAll() {
        String query = "SELECT rc.*, mh.plate, c.firstName, c.lastName, c.address, b.brand, m.model " +
                "FROM rentalcontracts rc, motorhomes mh, brands b, models m, customers c " +
                "WHERE rc.customerId = c.id AND rc.motorHomeId = mh.id AND mh.modelId = m.id AND m.brandId = b.id ORDER BY rc.id";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.query(query, rowMapper);
    }

    public List<Customer> fetchCustomers() {
        String query = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(query, rowMapper);
    }

    public List<Motorhome> fetchMotorhomes() {
        String query = "SELECT mh.*, m.model, b.brand FROM models m, brands b, motorhomes mh WHERE mh.modelId = m.id AND m.brandId = b.id";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(query, rowMapper);
    }

    public List<Accessory> fetchAccessories() {
        String query = "SELECT * FROM accessories";
        RowMapper<Accessory> rowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        return template.query(query, rowMapper);
    }

    public void add(RentalContract rc) {
        //check if location exists
        checkLocation(rc, rc.getNewPickUpLocation(), "pick");
        checkLocation(rc, rc.getNewDropOffLocation(), "drop");

        double rentalPrice = calculateRentalPrice(rc);
        rc.setTotalPrice(rentalPrice); //When a contract is created, we don't have postRentalPrice yet, hence the totalPrice will currently
        //be set to the initial RentalPrice

        String query = "INSERT INTO rentalcontracts (customerId, motorhomeId, accessoryId, season, fromDate, toDate, fuel, extraKm, pickUpLocation, dropOffLocation, " +
                "rentalprice, postRentalPrice, totalPrice, status)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, rc.getCustomerId(), rc.getMotorhomeId(), rc.getAccessoryId(), rc.getSeason(), rc.getFromDate(),
                rc.getToDate(), rc.getFuel(), rc.getExtraKm(), rc.getPickUpLocation(), rc.getDropOffLocation(), rentalPrice, 0,
                rc.getTotalPrice(), rc.getStatus());
    }

    public void checkLocation(RentalContract rc, String newLocation, String flag) {
        int locationId;

        if(doesLocationExist(newLocation)) {

            locationId = findLocationId(newLocation);
            if(flag.equals("pick")) {
                rc.setPickUpLocation(locationId);
            } else {
                rc.setDropOffLocation(locationId);
            }

        } else {
            String query = "INSERT INTO locations (name, free) VALUES (?, ?)";
            template.update(query, newLocation, 0); //0 means the location is different from the ones used by the company,
            // hence the customer is charged, 1 - the opposite

            locationId = findLocationId(newLocation);
            if(flag.equals("pick")) {
                rc.setPickUpLocation(locationId);
            } else {
                rc.setDropOffLocation(locationId);
            }
        }
    }

    public Boolean doesLocationExist(String location) {
        return template.queryForObject("SELECT EXISTS(SELECT name FROM locations WHERE name = \"" + location + "\")", Boolean.class);
    }

    public int findLocationId(String location) {
        String findLocationId = "SELECT l.id FROM locations l WHERE l.name = '" + location + "'";
        int locationId = template.queryForObject(findLocationId, int.class);
        return locationId;
    }

    public Boolean checkIfLocationIsPriced(int locationId) {
        int free = template.queryForObject("SELECT free FROM locations WHERE id = " + locationId, int.class);
        return free == 0 ? true : false;
    }

    public double findPricePerDay(RentalContract rc) {
        return template.queryForObject("SELECT pricePerDay FROM motorhomes WHERE id = " + rc.getMotorhomeId(), double.class);
    }

    public double findAccessoryPrice(RentalContract rc) {
        return template.queryForObject("SELECT price FROM accessories WHERE id = " + rc.getAccessoryId(), double.class);
    }

    public double updatePriceBasedOnSeason(double price, RentalContract rc) {
        String season = rc.getSeason();

        switch(season) {
            case "Low":
                break;
            case "Middle":
                price = price + (price * 30) / 100;
                System.out.println("Middle " + price);
                break;
            case "Peak":
                price = price + (price * 60) / 100;
                System.out.println("Peak " + price);
                break;
        }
        return price;
    }

    public double calculateRentalPrice(RentalContract rc) {
        // price per day * (toDate - fromDate) + pickUpLocation price + dropOffLocation price + accessory price (take season into account
        // as well)
        Date fromDate = rc.getFromDate();
        Date toDate = rc.getToDate();

        boolean pickUpIsPriced = checkIfLocationIsPriced(rc.getPickUpLocation());
        boolean dropOffIsPriced = checkIfLocationIsPriced(rc.getDropOffLocation());
        System.out.println(pickUpIsPriced);
        System.out.println(dropOffIsPriced);

        double pricePerDay;
        double pickUpLocationPrice;
        double dropOffLocationPrice;
        double accessoryPrice;

        pricePerDay = findPricePerDay(rc);

        Random random = new Random();
        if(pickUpIsPriced) {
            pickUpLocationPrice = 5 + random.nextDouble() * (500.00 - 5.00);
        } else {
            pickUpLocationPrice = 0.00;
        }

        if(dropOffIsPriced) {
            dropOffLocationPrice = 5 + random.nextDouble() * (500.00 - 5.00);
        } else {
            dropOffLocationPrice = 0.00;
        }

        accessoryPrice = findAccessoryPrice(rc);

        System.out.println("Initial " + pricePerDay);
        pricePerDay = updatePriceBasedOnSeason(pricePerDay, rc);
        System.out.println("After season update " + pricePerDay);
        System.out.println("PickUp " + pickUpLocationPrice);
        System.out.println("DropOff " + dropOffLocationPrice);
        System.out.println("Accessory " + accessoryPrice);

        double price = pricePerDay * ((int) (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24)) + pickUpLocationPrice +
                dropOffLocationPrice + accessoryPrice;

        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));
        System.out.println("total " + price);

        return price;
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
        String query = "SELECT rc.*, c.firstName, c.lastName, c.address, c.zipCodeCustomer, z.city, c.phoneNumber, c.email, c.driverLicenceNumber, " +
                "c.driverSinceDate, b.brand, m.model,  mh.plate, m.budget, m.size, m.fuelType, mh.cruiseControl, mh.hp, mh.seatNumber, mh.seatsMaterial, " +
                "mh.pricePerDay, a.accessory, a.price " +
                "FROM rentalcontracts rc, motorhomes mh, brands b, models m, customers c, zip z, accessories a " +
                "WHERE rc.customerId = c.id AND rc.motorHomeId = mh.id AND mh.modelId = m.id AND m.brandId = b.id AND c.zipCodeCustomer = z.zipCode " +
                "AND rc.accessoryId = a.id AND rc.id = ? ORDER BY rc.id";

        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.queryForObject(query, rowMapper, id);
    }

    public String findPickUpLocationName(int id) {
        int pickUpLocationId = findPickUpLocationId(id);
        String findPickUpLocationName = "SELECT l.name FROM locations l WHERE l.id = '" + pickUpLocationId + "'";
        return template.queryForObject(findPickUpLocationName, String.class);
    }

    public String findDropOffLocationName(int id) {
        int dropOffLocationId = findDropOffLocationId(id);
        String findDropOffLocationId = "SELECT l.name FROM locations l WHERE l.id = '" + dropOffLocationId + "'";
        return template.queryForObject(findDropOffLocationId, String.class);
    }

    private int findPickUpLocationId(int id) {
        String findLocationId = "SELECT rc.pickUpLocation FROM rentalContracts rc WHERE rc.id = " + id;
        int pickUpLocationId = template.queryForObject(findLocationId, int.class);
        return pickUpLocationId;
    }

    private int findDropOffLocationId(int id) {
        String findLocationId = "SELECT rc.dropOffLocation FROM rentalContracts rc WHERE rc.id = " + id;
        int dropOffLocationId = template.queryForObject(findLocationId, int.class);
        return dropOffLocationId;
    }

    public void update(RentalContract rc, int id) {
        String query = "UPDATE rentalcontracts SET customerId = ?, motorhomeId = ?, accessoryId = ?, season = ?, fromDate = ?, toDate = ?, fuel = ?, extraKm = ?, pickUpLocation = ?, dropOffLocation = ?," +
                "rentalprice = ?, postRentalPrice = ?, totalPrice = ?, status = ? WHERE id = ?";
        template.update(query, rc.getCustomerId(), rc.getMotorhomeId(), rc.getAccessoryId(), rc.getSeason(), rc.getFromDate(),
                rc.getToDate(), rc.getFuel(), rc.getExtraKm(), rc.getPickUpLocation(), rc.getDropOffLocation(), rc.getRentalPrice(), rc.getPostRentalPrice(),
                rc.getTotalPrice(), rc.getStatus(), id);
    }
}