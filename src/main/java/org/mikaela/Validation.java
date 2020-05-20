package org.mikaela;

public class Validation {
    static boolean validation(String user, String passHash) {

        String usernameA = "omar";
        int passwordAHash = -1332418844; //iloveyou
        String usernameB = "mika";
        int passwordBHash = 684683749; //snoopy12

        if (user != null) {
            if ((user.equals(usernameA)) && (passHash.hashCode() == (passwordAHash)) ||
                    (user.equals(usernameB)) && (passHash.hashCode() == (passwordBHash))) {
                return true;
            }
        }
        return false;

    }
}
