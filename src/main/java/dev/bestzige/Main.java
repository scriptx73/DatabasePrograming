package dev.bestzige;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "pass@bestzige";
        String database = "int103";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");

            Statement statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(Main.class.getName()).severe("Driver not found");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).severe("Cannot connect to database");
            throw new RuntimeException(e);
        }
    }
}