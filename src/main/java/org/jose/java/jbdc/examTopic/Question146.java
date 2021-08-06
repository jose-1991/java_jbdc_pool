package org.jose.java.jbdc.examTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Question146 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Properties prop = new Properties();
            prop.put("user","root");
            prop.put("password","sasa");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/La_Paz"
            ,prop);

//
            if (con != null){
                System.out.println("Connection Established");
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
