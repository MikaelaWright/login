package org.mikaela;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    static Connection userConnection = null;
    static PreparedStatement preparedStatement = null;

    static void makeConnection() { // function to connect to database

        String url = "jdbc:mysql://localhost:3306/login?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "P@ssw0rd";

        try {
            userConnection = DriverManager.getConnection(url, user, password);
            if (userConnection == null) {
                System.out.println("Failed to make connection.");
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed.");
            e.printStackTrace();
        }
    }

    static ArrayList<String> insertData(String username, int password) {
        // insert new user to database
        ArrayList<String> errors = new ArrayList<>(); // keep track of errors to display to user/tests
        if (retrieveUser(username) == 0) {
            // if 0 returns, retrieveUser unable to find matching credentials.
            createUser(username, password);
        } else {
            // If not 0, user already existed as retrieveUser returned inside iteration loop
            errors.add("user exists!");
        }
        return errors;
    }

    private static void createUser(String username, int password) {
        Database.makeConnection();
        try {
            String insertQueryStatement = "INSERT  INTO  user_pass (`username`, `password`)  VALUES  (?,?)";
            //adding variables to query statement
            preparedStatement = userConnection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, password);

            // execute insert SQL statement
            preparedStatement.executeUpdate();

            // close connections
            preparedStatement.close();
            userConnection.close();

        } catch (SQLException e) {
//            errors.add(e.getMessage());
            // stop program and display exception.
            throw new RuntimeException(e);
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
                return password;
            }
            // close connections
            preparedStatement.close();
            userConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if retrieval fails, return 0
        return 0;
    }
}
