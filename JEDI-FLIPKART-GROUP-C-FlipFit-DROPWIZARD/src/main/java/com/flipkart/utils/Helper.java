package com.flipkart.utils;

import com.flipkart.constants.ConsoleConstants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.flipkart.constants.ConsoleConstants.*;

/**
 * Utility class providing helper methods for common operations such as generating IDs,
 * parsing date and time, and printing colored and formatted text to the console.
 */
public class Helper {

    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("MM/yy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter HOUR_MIN_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private static final Random RANDOM = new Random();

    /**
     * Generates a random 6-character ID consisting of uppercase letters and digits.
     *
     * @return A randomly generated 6-character ID.
     */
    public static String generateId() {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int randomIndex = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(randomIndex));
        }

        return sb.toString();
    }

    /**
     * Parses a date string into a {@code LocalDate} object.
     *
     * @param date The date string to parse, in the format "dd-MM-yyyy".
     * @return The parsed {@code LocalDate} object.
     */
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }

    /**
     * Parses a YearMonth from a string using the defined formatter.
     *
     * @param yearMonth the string to parse
     * @return the parsed YearMonth
     */
    public static YearMonth parseYearMonth(String yearMonth) {
        return YearMonth.parse(yearMonth, YEAR_MONTH_FORMATTER);
    }

    /**
     * Parses a time string into a {@code LocalTime} object.
     *
     * @param hourMinute The time string to parse, in the format "HH:mm".
     * @return The parsed {@code LocalTime} object.
     */
    public static LocalTime parseHourMinute(String hourMinute) {
        return LocalTime.parse(hourMinute, HOUR_MIN_TIME_FORMATTER);
    }

    /**
     * Prints the given text in bold to the console, followed by a newline.
     *
     * @param text The text to print in bold.
     */
    public static void boldOutputLn(String text) {
        System.out.println(ConsoleConstants.BOLD + text + ConsoleConstants.RESET);
    }

    /**
     * Prints the given text in the specified color to the console, followed by a newline.
     *
     * @param text The text to print.
     * @param color The color code to use for the text.
     */
    public static void coloredOutputLn(String text, String color) {
        System.out.println(color + text + ConsoleConstants.RESET);
    }

    /**
     * Prints the given text in the specified color to the console, without a newline.
     *
     * @param text The text to print.
     * @param color The color code to use for the text.
     */
    public static void coloredOutput(String text, String color) {
        System.out.print(color + text + ConsoleConstants.RESET);
    }

    /**
     * Prints the given text in green to the console, followed by a newline.
     *
     * @param text The text to print in green.
     */
    public static void greenOutputLn(String text) {
        coloredOutputLn(text, GREEN);
    }

    /**
     * Prints the given text in blue to the console, followed by a newline.
     *
     * @param text The text to print in blue.
     */
    public static void blueOutputLn(String text) {
        coloredOutputLn(text, BLUE);
    }

    /**
     * Prints the given text in blue to the console, without a newline.
     *
     * @param text The text to print in blue.
     */
    public static void blueOutput(String text) {
        coloredOutput(text, BLUE);
    }

    /**
     * Prints the given text in red to the console, followed by a newline.
     *
     * @param text The text to print in red.
     */
    public static void redOutputLn(String text) {
        coloredOutputLn(text, RED);
    }

    /**
     * Prints the given text in yellow to the console, followed by a newline.
     *
     * @param text The text to print in yellow.
     */
    public static void yellowOutputLn(String text) {
        coloredOutputLn(text, YELLOW);
    }
}
