package com.example.jdbc_ws;

import com.example.jdbc_ws.dao.BuildingDAO;
import com.example.jdbc_ws.dao.CountryDAO;
import com.example.jdbc_ws.model.Building;
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
        List<Country> countryList = countryDAO.getCountries();
        for (Country country : countryList) {
            System.out.println(country);
        }
        List<Building> buildingList = buildingDAO.findAll();
        buildingList.forEach(System.out::println);
        List<Building> buildingListByCountryCode = buildingDAO.findByCountryCode("HU");
        buildingListByCountryCode.forEach(System.out::println);
        buildingDAO.changeCountry("MOL Campus", "FR");
        buildingDAO.findByCountryCode("FR").forEach(System.out::println);
    }
}
