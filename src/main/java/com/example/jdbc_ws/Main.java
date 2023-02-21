package com.example.jdbc_ws;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/travelagency";
        try (
                Connection con = DriverManager.getConnection(url, "travelagent", "agent");
                PreparedStatement st = con.prepareStatement("SELECT * FROM country")
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("countryname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
