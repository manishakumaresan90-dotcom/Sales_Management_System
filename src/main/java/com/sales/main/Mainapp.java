package com.sales.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mainapp {
    public static void main(String[] args) {
        // Change "sales_db" to your actual MySQL database name if it is different
    	String url = "jdbc:mysql://localhost:3306/sales_management";
        String user = "root";       // Your MySQL username
        String password = "password";   // Your MySQL password (change if needed)

        try {
            // Force Java to load the MySQL Driver directly
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("DATABASE CONNECTED SUCCESSFUL!");
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}