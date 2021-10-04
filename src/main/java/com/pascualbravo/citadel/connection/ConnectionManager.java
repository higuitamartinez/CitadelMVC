package com.pascualbravo.citadel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:postgresql://localhost:your_port/bookshop_citadel";
    private static final String USER="your_user";
    private static final String PASSWORD="your_pass";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
   
}
