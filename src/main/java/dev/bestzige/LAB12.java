package dev.bestzige;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB12 {
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
            String queryString = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, 651073);
            preparedStatement.setString(2, "Watchara");
            preparedStatement.setString(3, "Santawee");
            preparedStatement.setString(4, "bestzige@hotmail.com");
            preparedStatement.setString(5, "IT");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
}
