package org.mikaela;

import java.sql.*;

public class Database {

    static Connection userConnection = null;
    static PreparedStatement preparedStatement = null;

    static void makeConnection() {

        String url = "jdbc:mysql://localhost:3306/login?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "P@ssw0rd";

        try {
            userConnection = DriverManager.getConnection(url, user, password);
            if (userConnection != null) {
                System.out.println("Connection Successful.");
            } else {
                System.out.println("Failed to make connection.");
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed.");
            e.printStackTrace();
        }
    }

    static void insertData(String username, int password) {
        Database.makeConnection();
        try {
            String insertQueryStatement = "INSERT  INTO  user_pass (`username`, `password`)  VALUES  (?,?)";

            preparedStatement = userConnection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, password);

            // execute insert SQL statement
            preparedStatement.executeUpdate();
            System.out.println(username + " added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static int retrieveUser(String username) { //executeQuery()

        Database.makeConnection();
        try {
            String getQueryStatement = String.format("SELECT * FROM user_pass WHERE username= '%s'   ", username);
            preparedStatement = userConnection.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // iterate through results
            while (resultSet.next()) {
                int password = resultSet.getInt("password");
                System.out.format("%s, %s\n", username, password);
                return password;
            }

            preparedStatement.close();
            userConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private static void updateData() {

    }
}
