package com.example.jdbc_ws;

import com.example.jdbc_ws.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class JdbcWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcWsApplication.class, args);
    }

}
@Component
class CountryPrinter implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "select code, countryname, in_eu from country";
        List<Country> countries = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Country(
                        rs.getString("code"),
                        rs.getString("countryname"),
                        rs.getBoolean("in_eu")
                )
        );

        countries.forEach(System.out::println);
    }
}
