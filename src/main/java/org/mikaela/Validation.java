package org.mikaela;

public class Validation {
    static boolean validation(String user, String userPass) {

        String usernameA = "omar";
        String passwordA = "iloveyou";

        String usernameB = "mika";
        String passwordB = "snoopy12";

        if ((user.equals(usernameA)) && (userPass.equals(passwordA)) ||
                (user.equals(usernameB)) && (userPass.equals(passwordB))) {
            return true;
        } else {
            return false;
        }
    }
}
