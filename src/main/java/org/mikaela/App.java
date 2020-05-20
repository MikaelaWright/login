package org.mikaela;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean login = false;

        while (!login) {

            System.out.println("Enter username: ");
            String user = scanner.next();

            System.out.println("Enter password: ");
            String userPass = scanner.next();

            if (Validation.validation(user, userPass)) {
                System.out.println("Welcome " + user + "!");
                login = true;
            } else {
                System.out.println("Invalid, try again.");
                login = false;
            }
        }
    }
}


