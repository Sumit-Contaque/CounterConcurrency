package com.example.ThreadSafe.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getValue(){
        String insertQuery=" SELECT ID from number";
        return jdbcTemplate.queryForObject(insertQuery,Integer.class);
    }


    public Integer setInitialValue(){
        String insertQuery=" UPDATE number SET ID = 0";
        return jdbcTemplate.update(insertQuery);
    }

    public int updateValue(){
        String insertQuery=" UPDATE number SET ID = COALESCE(id, 0) + 1";
        jdbcTemplate.update(insertQuery);
        return jdbcTemplate.queryForObject("SELECT COALESCE(id, 0) from number", Integer.class);
    }
}
