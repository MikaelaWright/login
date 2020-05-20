package org.mikaela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static void main(String[] args) {

    }


    private static void makeConnection() {

        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = "P@ssw0rd";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connection Successful.");
            } else {
                System.out.println("Failed to make connection.");
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed.");
            e.printStackTrace();
        }
    }

    private static void insertData() { //executeUpdate()
        // insert username and password (as hash)
    }

    private static void updateData() {

    }

    private static void retrieveData() { //executeQuery()

    }
}
