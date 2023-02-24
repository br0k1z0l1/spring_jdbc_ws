package com.example.jdbc_ws.dao;

import com.example.jdbc_ws.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAO {
    private JdbcTemplate template;
    @Autowired
    public CountryDAO(JdbcTemplate template) {
        this.template = template;
    }

    public List<Country> getCountries() {
        List<Country> countryList = template.query("SELECT * FROM country", (rs, rowNum) -> new Country(
                rs.getString("code"),
                rs.getString("countryname"),
                rs.getBoolean("in_eu"))
        );
        return countryList;
    }
}