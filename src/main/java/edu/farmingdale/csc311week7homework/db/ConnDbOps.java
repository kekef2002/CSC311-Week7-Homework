package edu.farmingdale.csc311week7homework.db;

import edu.farmingdale.csc311week7homework.Person;

import java.sql.*;

public class ConnDbOps {
    final String DB_URL = "jdbc:mysql://francois-server.mysql.database.azure.com/DBname";
    final String USERNAME = "kfrancois";
    final String PASSWORD = "farmingdale#1030";

    public void connectToDatabase() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(200), email VARCHAR(200) UNIQUE, " +
                    "phone VARCHAR(200), address VARCHAR(200), " +
                    "password VARCHAR(200))";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(Person person) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirstName() + " " + person.getLastName());
            preparedStatement.setString(2, "dummy@example.com"); // Replace with actual
            preparedStatement.setString(3, "123-456-7890");  // Replace with actual
            preparedStatement.setString(4, "Some Address");  // Replace with actual
            preparedStatement.setString(5, "password123");  // Replace with actual
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Person person) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE users SET name = ?, dept = ?, major = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirstName() + " " + person.getLastName());
            preparedStatement.setString(2, person.getDept());
            preparedStatement.setString(3, person.getMajor());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
