package com.example.jdbc_ws;

import com.example.jdbc_ws.dao.BuildingDAO;
import com.example.jdbc_ws.dao.CountryDAO;
import com.example.jdbc_ws.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataTest implements CommandLineRunner {

    JdbcTemplate template;
    CountryDAO countryDAO;
    BuildingDAO buildingDAO;
    @Autowired
    public DataTest(JdbcTemplate template, CountryDAO countryDAO, BuildingDAO buildingDAO) {
        this.template = template;
        this.countryDAO = countryDAO;
        this.buildingDAO = buildingDAO;
    }

    @Override
    public void run(String... args) {

        System.out.println("-".repeat(80));
        System.out.println("All countries:");
        List<Country> countryList = countryDAO.getCountries();
        for (Country country : countryList) {
            System.out.println(country);
        }

        System.out.println("-".repeat(80));
        System.out.println("All buildings:");
        buildingDAO.findAll().forEach(System.out::println);

        System.out.println("-".repeat(80));
        System.out.println("All hungarian buildings:");
        buildingDAO.findByCountryCode("HU").forEach(System.out::println);

        System.out.println("-".repeat(80));
        System.out.println("All french buildings (Mol campus changed to french):");
        buildingDAO.changeCountry("Mol Campus", "FR");
        buildingDAO.findByCountryCode("FR").forEach(System.out::println);
        System.out.println("-".repeat(80));

    }
}
