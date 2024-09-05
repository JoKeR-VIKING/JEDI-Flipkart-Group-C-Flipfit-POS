package com.flipkart.utils;

import java.util.Random;

public class Helper {
    private static final Random RANDOM = new Random();

    public static String generateId() {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(6);

        for (int i=0;i<6;i++) {
            int randomIndex = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(randomIndex));
        }

        return sb.toString();
    }
}
