package org.mikaela;

import java.util.ArrayList;

public class UserService {

    static boolean lookup(String user, String plainPassword) {

        int hashedPassword = Database.retrieveUser(user);

        if (plainPassword == null) {
            //no password entered
            System.out.println("No password entered");
            return false;
        }
        if (hashedPassword == 0) {
            //retrieveUser returns 0 when no username was found that matched input
            System.out.println("user does not exist");
            return false;
        }
        if (plainPassword.hashCode() == hashedPassword) {
            //username and password match database lookup
            System.out.println("all good!");
            return true;
        }
        if (plainPassword.hashCode() != hashedPassword) {
            //username is correct, but password in database does not match entered password
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
