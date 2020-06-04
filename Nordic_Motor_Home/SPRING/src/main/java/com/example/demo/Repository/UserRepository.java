package com.example.demo.Repository;

import com.example.demo.Model.RentalContract;
import com.example.demo.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserRepository{

    JdbcTemplate template;
    public User findByUsername(String username) {  //only plate now
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.queryForObject(query, rowMapper);
    }
}
