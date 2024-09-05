package com.flipkart.utils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlipfitClientUtils {
    public static int getChoice(int size) {
        Scanner in = new Scanner(System.in);
        int choice;

        try {
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            if (choice < 0 || choice > size)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("incorrect input, try again: ");
            return getChoice(size);
        }
        return choice;
    }

    public static String getOptionsWithId(List<String> options) {
        return IntStream.range(0, options.size())
                .mapToObj(optionIdx -> String.format("%d. %s", optionIdx + 1, options.get(optionIdx)))
                .collect(Collectors.joining("\n"));
    }
}