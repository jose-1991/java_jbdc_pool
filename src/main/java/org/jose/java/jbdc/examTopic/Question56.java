package org.jose.java.jbdc.examTopic;

import java.sql.*;

public class Question56 {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/La_Paz";
    private static String username = "root";
    private static String password = "sasa";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "Select * FROM productos WHERE ID = 6";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("precio: " + rs.getDouble("precio"));
                System.out.println("fecha:" + rs.getInt(" fecha_registro "));
            }
        } catch (SQLException se) {
            System.out.println("Error");
        }
    }
}
