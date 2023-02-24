package com.example.jdbc_ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Building {
    private String buildingName;
    private String countryCode;
    private int height;
}