package com.flipkart.client;

import java.util.Scanner;

public class FlipfitClientUtils {
    public static int getChoice(int size) {
        Scanner in = new Scanner(System.in);
        int choice;
        try {
            choice = in.nextInt();
            if (choice < 0 || choice > size)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("incorrect input, try again: ");
            return getChoice(size);
        }
        return choice;
    }
}
