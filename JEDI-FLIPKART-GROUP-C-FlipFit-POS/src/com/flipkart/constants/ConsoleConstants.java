package com.flipkart.constants;

import java.time.format.DateTimeFormatter;

/**
 * A utility class that contains constants for console text formatting.
 */

public class ConsoleConstants {
    /**
     * ANSI escape code for bold text.
     */
    public static final String BOLD = "\033[0;1m";

    /**
     * ANSI escape code to reset text formatting to default.
     */
    public static final String RESET = "\033[0m";

    /**
     * ANSI escape code for green text.
     */
    public static final String GREEN = "\033[0;32m";

    /**
     * ANSI escape code for blue text.
     */
    public static final String BLUE = "\033[0;34m";

    /**
     * ANSI escape code for red text.
     */
    public static final String RED = "\033[0;31m";

    /**
     * ANSI escape code for yellow text.
     */
    public static final String YELLOW = "\033[0;33m";
  
    /**
     * Format for LocalDate
     */
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
}
