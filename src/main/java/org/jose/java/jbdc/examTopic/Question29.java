package org.jose.java.jbdc.examTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question29 {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/La_Paz";
    private static String username = "root";
    private static String password = "sasa";
    static Connection newConnection = null;

    public static Connection getDBConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url,username,password);
            newConnection = con;

        return newConnection;
    }

    public static void main(String[] args) throws SQLException {
        try (Statement st = getDBConnection().createStatement()){
            st.executeUpdate("INSERT INTO estudiantes VALUES(99,'Kelvin')");
        }



    }
}
