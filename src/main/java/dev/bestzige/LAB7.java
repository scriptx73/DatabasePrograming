package dev.bestzige;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB7 {
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
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM students";
            statement.executeQuery(queryString);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
}
