package org.mikaela;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        boolean login = false;

        while (!login) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            String user = scanner.next();
            System.out.println("Enter password: ");
            String userPass = scanner.next();

            login = validation(user, userPass);
            if (login) {
                System.out.println("Welcome " + user + "!");
            } else {
                System.out.println("Invalid, try again.");
            }
        }
    }

    private static boolean validation(String user, String userPass) {

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

