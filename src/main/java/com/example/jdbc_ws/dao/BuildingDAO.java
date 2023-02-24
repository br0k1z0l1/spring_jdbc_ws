package com.example.jdbc_ws.dao;

import com.example.jdbc_ws.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDAO {
    private JdbcTemplate template;

    @Autowired
    public BuildingDAO(JdbcTemplate template) {
        this.template = template;
    }

    public List<Building> findAll() {
        List<Building> buildingList = template.query("SELECT * FROM famousbuilding",
                (rs, rowNum) -> new Building(
                        rs.getString("buildingname"),
                        rs.getString("countrycode"),
                        rs.getInt("height"))
        );
        return buildingList;
    }

    public List<Building> findByCountryCode(String countryCode) {
        List<Building> buildingListByCountry = template.query(
                "SELECT * FROM famousbuilding WHERE countrycode=?", (PreparedStatementSetter) ps ->
                        ps.setString(1, countryCode),
                (rs, rowNum) -> new Building(
                        rs.getString("buildingname"),
                        rs.getString("countrycode"),
                        rs.getInt("height"))
        );
        return buildingListByCountry;
    }

    public void changeCountry(String buildingName, String newCountryCode) {
        String sql = "UPDATE famousbuilding SET countrycode = ? WHERE buildingname = ?";
        template.update(sql, ps -> {
            ps.setString(1, newCountryCode);
            ps.setString(2, buildingName);
        });
    }
}