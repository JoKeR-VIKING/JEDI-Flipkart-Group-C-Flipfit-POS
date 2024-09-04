package com.flipkart.client;

import java.util.Scanner;

public class FlipFitApplicationMainClient {
    private static void loginMenu() {

    }

    private static void changePasswordMenu() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Welcome to FlipFit App-----------");

        System.out.println("1. Login");
        System.out.println("2. Change Password");
        System.out.println("3. Gym Customer Registration");
        System.out.println("4. Gym Owner Registration");
        System.out.println("5. Logout");

        int menuOption = sc.nextInt();

        switch (menuOption) {
            case 1 -> loginMenu();
            case 2 -> changePasswordMenu();
        }

        sc.close();
    }
}
