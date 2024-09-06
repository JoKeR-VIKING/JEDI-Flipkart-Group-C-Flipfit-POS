package com.flipkart.utils;

import java.util.Scanner;

import static com.flipkart.utils.Helper.blueOutput;
import static com.flipkart.utils.Helper.redOutputLn;

public class FlipfitClientUtils {
    public static int getChoice(int size) {
        Scanner in = new Scanner(System.in);
        int choice;

        try {
            blueOutput("\nEnter choice: ");
            choice = in.nextInt();
            in.nextLine();
            if (choice < 0 || choice > size)
                throw new Exception();
        } catch (Exception e) {
            redOutputLn("Incorrect input, try again: ");
            return getChoice(size);
        }
        return choice;
    }
}