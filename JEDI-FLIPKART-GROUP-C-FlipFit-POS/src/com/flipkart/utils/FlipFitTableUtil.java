package com.flipkart.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for formatting and printing tabular data.
 */
public class FlipFitTableUtil {

    /**
     * Prints tabular data to the console.
     *
     * @param columns A list of column headers.
     * @param rows A list of rows, where each row is a list of strings representing the cell values.
     */
    public static void printTabular(List<String> columns, List<List<String>> rows) {
        List<Integer> columnWidths = new ArrayList<>();
        int totalWidth = 0;

        // Calculate the maximum width required for each column.
        for (int i = 0; i < columns.size(); ++i) {
            final int fI = i;

            List<String> rowsColumn = rows.stream().map(row -> row.get(fI)).toList();

            columnWidths.add(
                    Math.max(
                            rowsColumn.isEmpty() ? 0 : Collections.max(rowsColumn.stream()
                                    .map(rowColumn -> rowColumn.length() + 4)
                                    .toList()),
                            columns.get(i).length()
                    )
            );

            totalWidth += columnWidths.get(columnWidths.size() - 1);
        }

        // Create the format string for the table columns.
        String columnFormat = String.format("| %s |%n", columnWidths.stream()
                .map(width -> "%-" + width + "s")
                .collect(Collectors.joining(" | ")));

        // Print the column headers.
        System.out.printf(columnFormat, columns.toArray(Object[]::new));

        // Print the separator line.
        System.out.println("-".repeat(totalWidth + columns.size() * 4 - 3));

        // Print the rows.
        rows.forEach(row -> System.out.printf(columnFormat, row.toArray(Object[]::new)));
    }
}
