package dev.bestzige;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB15 {
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
            ResultSet resultSet = statement.executeQuery(queryString);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%s\t", resultSetMetaData.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%s\t", resultSet.getString(i));
                }
                System.out.println();
            }
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
