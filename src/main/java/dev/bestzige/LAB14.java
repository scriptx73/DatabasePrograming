package dev.bestzige;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB14 {
    public static void main(String[] args) {
        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "pass@bestzige";
        String database = "int103";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database name: " + metaData.getDatabaseProductName());
            System.out.println("Database version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver name: " + metaData.getDriverName());
            System.out.println("Driver version: " + metaData.getDriverVersion());
            System.out.println("Driver Major version: " + metaData.getDriverMajorVersion());
            System.out.println("Driver Minor version: " + metaData.getDriverMinorVersion());
            System.out.println("Max connections: " + metaData.getMaxConnections());
            System.out.println("URL: " + metaData.getURL());
            System.out.println("User name: " + metaData.getUserName());
            System.out.println("Max table name length: " + metaData.getMaxTableNameLength());
            System.out.println("Max column name length: " + metaData.getMaxColumnNameLength());
            System.out.println("Max columns in table: " + metaData.getMaxColumnsInTable());
            System.out.println("Max row size: " + metaData.getMaxRowSize());
            System.out.println("Max statement length: " + metaData.getMaxStatementLength());
            System.out.println("Max statements: " + metaData.getMaxStatements());
            connection.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
}
