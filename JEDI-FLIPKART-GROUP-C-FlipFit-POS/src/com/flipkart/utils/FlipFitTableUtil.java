package com.flipkart.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlipFitTableUtil {

    public static void printTabular(List<String> columns, List<List<String>> rows) {
        List<Integer> columnWidths = new ArrayList<>();

        int totalWidth = 0;

        for (int i = 0; i < columns.size(); ++i) {
            final int fI = i;

            List<String> rowsColumn = rows.stream().map(row -> row.get(fI)).toList();

            columnWidths.add(
                    Math.max(
                            Collections.max(rowsColumn.stream()
                                    .map(rowColumn -> rowColumn.length() + 4)
                                    .toList()),
                            columns.get(i).length()
                    )
            );

            totalWidth += columnWidths.get(columnWidths.size() - 1);
        }

        String columnFormat = String.format("| %s |%n", columnWidths.stream()
                .map(width -> "%-" + width + "s")
                .collect(Collectors.joining(" | ")));

        System.out.printf(columnFormat, columns.toArray(Object[]::new));

        System.out.println("-".repeat(totalWidth + columns.size() * 4 - 3));

        for (List<String> row : rows) {
            System.out.printf(columnFormat, row.toArray(Object[]::new));
        }
    }
}
