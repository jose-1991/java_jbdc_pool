package org.jose.java.jbdc.examTopic;

import java.sql.*;

public class Question53 {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/La_Paz";
    private static String username = "root";
    private static String password = "sasa";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        String query = "SELECT id FROM productos";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
//            stmt.executeQuery("SELECT id FROM categorias");
            while (rs.next()) {
                //process the results
                System.out.println("Employee ID: " + rs.getInt("id"));
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
