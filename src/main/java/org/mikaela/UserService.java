package org.mikaela;

import java.util.ArrayList;

public class UserService {

    static boolean lookup(String user, String plainPassword) {

        int hashedPassword = Database.retrieveUser(user);
        if (hashedPassword == 0) {
            System.out.println("user does not exist");
            return false;
        }
        if (plainPassword.hashCode() == hashedPassword) {
            System.out.println("all good!");
            return true;
        }
        if (plainPassword.hashCode() != hashedPassword) {
            System.out.println("invalid password");
            return false;
        }
        return false;

    }

    static ArrayList<String> register(String username, String password) {
        int passHash = password.hashCode();
        return Database.insertData(username, passHash);
    }
}
