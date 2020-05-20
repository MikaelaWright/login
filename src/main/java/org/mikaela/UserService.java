package org.mikaela;

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
//        if (user != null) {
//
//
//            return true;
//        }
        return false;

//        String usernameA = "omar";
//        int passwordAHash = -1332418844; //iloveyou
//        String usernameB = "mika";
//        int passwordBHash = 684683749; //snoopy12
//
//        if (user != null) {
//            if ((user.equals(usernameA)) && (passHash.hashCode() == (passwordAHash)) ||
//                    (user.equals(usernameB)) && (passHash.hashCode() == (passwordBHash))) {
//                return true;
//            }
//        }
//        return false;

    }

    public static void register(String username, String password) {
        int passHash = password.hashCode();
        Database.insertData(username, passHash);
    }
}
