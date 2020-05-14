package org.mikaela;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String username = "omar";
        String password = "snoopy12";


        boolean login = false;

        while (login) {
            login = validation(username, password);
        }
    }

    private static boolean validation(String username, String password) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userInput = scanner.next();
        System.out.println("Enter password: ");
        String userPass = scanner.next();

        if ((userInput.equals(username)) && (userPass.equals(password))) {
            return true;

        } else {
            return false;
        }
    }

}

