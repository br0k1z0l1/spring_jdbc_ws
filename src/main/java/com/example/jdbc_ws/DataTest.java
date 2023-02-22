package com.example.jdbc_ws;

import com.example.jdbc_ws.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class DataTest implements CommandLineRunner {

    @Autowired
    JdbcTemplate template;

    @Override
    public void run(String... args) {
        List<Country> countryList = template.query(
                "SELECT * FROM country",
                (rs, rowNum) -> new Country(
                        rs.getString("code"),
                        rs.getString("countryname"),
                        rs.getBoolean("in_eu")
                )
        );
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}
