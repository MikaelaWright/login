package org.mikaela;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean login = false;

        while (!login) {

            System.out.println("New user?: y/n");
            String newUser = scanner.next();

            if (newUser.equals("n")) {
                System.out.println("Enter username: ");
                String user = scanner.next();

                System.out.println("Enter password: ");
                String userPass = scanner.next();

                if (UserService.lookup(user, userPass)) {
                    System.out.println("Welcome " + user + "!");
                    login = true;
                } else {
                    System.out.println("Invalid, try again.");
                    login = false;
                }
            } else {
                System.out.println("Enter new username: ");
                String username = scanner.next();
                System.out.println("Enter new password: ");
                String password = scanner.next();
//                while (password == null || password.equals("")) {
//                    System.out.println("No password entered, try again: ");
//                    password = scanner.next();
//                }
                UserService.register(username, password);
                System.out.println("Successfully registered.");
            }

        }
    }
}


