package com.flipkart.utils;

import com.flipkart.constants.ConsoleConstants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.flipkart.constants.ConsoleConstants.*;

public class Helper {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter HOUR_MIN_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private static final Random RANDOM = new Random();

    public static String generateId() {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int randomIndex = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }

    public static LocalTime parseHourMinute(String hourMinute) {
        return LocalTime.parse(hourMinute, HOUR_MIN_TIME_FORMATTER);
    }

    public static void boldOutputLn(String text) {
        System.out.println(ConsoleConstants.BOLD + text + ConsoleConstants.RESET);
    }

    public static void coloredOutputLn(String text, String color) {
        System.out.println(color + text + ConsoleConstants.RESET);
    }

    public static void coloredOutput(String text, String color) {
        System.out.print(color + text + ConsoleConstants.RESET);
    }

    public static void greenOutputLn(String text) {
        coloredOutputLn(text, GREEN);
    }

    public static void blueOutputLn(String text) {
        coloredOutputLn(text, BLUE);
    }

    public static void blueOutput(String text) {
        coloredOutput(text, BLUE);
    }

    public static void redOutputLn(String text) {
        coloredOutputLn(text, RED);
    }

    public static void yellowOutputLn(String text) {
        coloredOutputLn(text, YELLOW);
    }
}
