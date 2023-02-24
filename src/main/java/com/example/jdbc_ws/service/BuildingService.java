package com.example.jdbc_ws.service;

import com.example.jdbc_ws.dao.BuildingDAO;
import com.example.jdbc_ws.model.Building;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record BuildingService(BuildingDAO buildingDAO) {
    public List<Building> findAll() {
        return buildingDAO.findAll();
    }

    public List<Building> findByCountryCode(String countryCode) {
        return buildingDAO.findByCountryCode(countryCode);
    }

    public void changeCountry(String buildingName, String newCountryCode) {
        buildingDAO.changeCountry(buildingName, newCountryCode);
    }

    public Optional<Building> findBuildingByName(String name) {
        return buildingDAO.findAll()
                .stream()
                .filter(building -> building.getBuildingName().equals(name))
                .findFirst();
    }
}
