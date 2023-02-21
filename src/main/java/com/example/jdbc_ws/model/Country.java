package com.example.jdbc_ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
    private String code;
    private String countryName;
    private boolean inEu;
}
