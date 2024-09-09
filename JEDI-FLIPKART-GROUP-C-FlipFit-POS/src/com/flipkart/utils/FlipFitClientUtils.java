package com.flipkart.utils;

import java.util.Scanner;

import static com.flipkart.utils.Helper.blueOutput;
import static com.flipkart.utils.Helper.redOutputLn;

/**
 * Utility class for client-side operations in the FlipFit application.
 */
public class FlipFitClientUtils {

    /**
     * Prompts the user to enter a choice and validates the input.
     *
     * @param size The maximum valid choice (inclusive). The user's input must be between 0 and this value.
     * @return The user's choice as an integer if the input is valid.
     */
    public static int getChoice(int size) {
        Scanner in = new Scanner(System.in);
        int choice;

        try {
            blueOutput("\nEnter choice: ");
            choice = in.nextInt();
            in.nextLine();  // Consume the newline character
            if (choice < 0 || choice > size) {
                throw new Exception();
            }
        } catch (Exception e) {
            redOutputLn("Incorrect input, try again: ");
            return getChoice(size);
        }
        return choice;
    }
}
