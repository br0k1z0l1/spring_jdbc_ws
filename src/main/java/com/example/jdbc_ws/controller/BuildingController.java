package com.example.jdbc_ws.controller;

import com.example.jdbc_ws.model.Building;
import com.example.jdbc_ws.service.BuildingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public record BuildingController(BuildingService buildingService) {
    @GetMapping("/buildings")
    public List<Building> findAll() {
        return buildingService.findAll();
    }
    @GetMapping("/buildings/{countrycode}")
    public List<Building> findByCountryCode(@PathVariable String countryCode) {
        return buildingService.findByCountryCode(countryCode);
    }

    @PutMapping(value = "/buildings", params ={"buildingname", "newCountryCode"} )
    public ResponseEntity<Optional<Building>> changeCountry(@RequestParam("buildingname") String buildingName, @RequestParam String newCountryCode) {
        Optional<Building> maybeBuilding = buildingService.findBuildingByName(buildingName);
        if (maybeBuilding.isPresent()) {
            buildingService.changeCountry(buildingName, newCountryCode);
            return new ResponseEntity<>(buildingService.findBuildingByName(buildingName), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/buildings")
    public ResponseEntity<Optional<Building>> changeCountryByRespBody(@RequestBody ChangeCountryRequestDTO request) {
        Optional<Building> maybeBuilding = buildingService.findBuildingByName(request.buildingName());
        if (maybeBuilding.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        buildingService.changeCountry(request.buildingName(), request.newCountryCode());
        return new ResponseEntity<>(buildingService.findBuildingByName(request.buildingName()), HttpStatus.OK);
    }

    record ChangeCountryRequestDTO(String buildingName, String newCountryCode) {
    }

}
