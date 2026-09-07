package org.anudip.sms.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/sales_management";
        String user = "root";
        String password = "subiksha123"; 
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database connection helper failed!");
            e.printStackTrace();
        }
        return conn;
    }
}
