package sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class OutputFormatter {

    private static String getDataTypeLabel(String dataType) {
        return switch (dataType) {
            case "long" -> "numbers";
            case "line" -> "lines";
            case "word" -> "words";
            default -> "items";
        };
    }

    // TODO: Refactor with generic displayNatural and displayCount

    public static void displayOutputLong(DataParts<Long> outputParts, String sortingType, String outputFile) throws IOException {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputLong(outputParts, "long", outputFile);
            case "byCount" -> displayCountSortingOutputLong(outputParts, "long", outputFile);
        }
    }

    public static void displayOutputLine(DataParts<String> outputParts, String sortingType, String outputFile) throws IOException {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputLine(outputParts, "line", outputFile);
            case "byCount" -> displayCountSortingOutputLine(outputParts, "line", outputFile);
        }
    }

    public static void displayOutputWord(DataParts<String> outputParts, String sortingType, String outputFile) throws IOException {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputWord(outputParts, "word", outputFile);
            case "byCount" -> displayCountSortingOutputWord(outputParts, "word", outputFile);
        }
    }

    private static void displayNaturalSortingOutputLong(DataParts<Long> outputParts, String dataType, String outputFile) throws IOException {
        List<Long> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<Long> longList = parts.stream()
                .filter(obj -> obj instanceof Long)
                .map(obj -> (Long) obj)
                .collect(Collectors.toList());
        Collections.sort(longList);

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                out.print("Sorted data: ");
                for (Long number : longList) {
                    out.print(number + " ");
                }
            }
        } else {
            System.out.print(result);
            System.out.print("Sorted data: ");
            for (Long number : longList) {
                System.out.print(number + " ");
            }
        }
    }

    private static void displayNaturalSortingOutputLine(DataParts<String> outputParts, String dataType, String outputFile) throws IOException {
        List<String> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<String> lineList = parts.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .collect(Collectors.toList());
        Collections.sort(lineList);

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                out.print("Sorted data: ");
                for (String line : lineList) {
                    out.println(line);
                }
            }
        } else {
            System.out.print(result);
            System.out.println("Sorted data:");
            for (String line : lineList) {
                System.out.println(line);
            }
        }
    }

    private static void displayNaturalSortingOutputWord(DataParts<String> outputParts, String dataType, String outputFile) throws IOException {
        List<String> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<String> wordList = parts.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .collect(Collectors.toList());
        Collections.sort(wordList);
        System.out.print("Sorted data: ");
        for (String word : wordList) {
            System.out.print(word + " ");
        }

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                out.print("Sorted data: ");
                for (String word : wordList) {
                    out.print(word + " ");
                }
            }
        } else {
            System.out.print(result);
            System.out.print("Sorted data: ");
            for (String word : wordList) {
                System.out.print(word + " ");
            }
        }
    }

    private static void displayCountSortingOutputLong(DataParts<Long> outputParts, String dataType, String outputFile) throws IOException {
        List<Long> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        Map<Long, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each element
        for (Long element : parts) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Sort the elements by count and then by natural order using a custom Comparator
        List<Map.Entry<Long, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(new CountComparator<>());

        // Calculate the total number of elements
        int totalElements = parts.size();

        // Output the sorted elements with count and percentage

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                for (Map.Entry<Long, Integer> entry : sortedEntries) {
                    Long element = entry.getKey();
                    int count = entry.getValue();
                    double percentage = (double) count / totalElements * 100;
                    out.printf("%d: %d time(s), %.0f%%\n", element, count, percentage);
                }
            }
        } else {
            System.out.print(result);
            for (Map.Entry<Long, Integer> entry : sortedEntries) {
                Long element = entry.getKey();
                int count = entry.getValue();
                double percentage = (double) count / totalElements * 100;
                System.out.printf("%d: %d time(s), %.0f%%\n", element, count, percentage);
            }
        }


    }

    private static void displayCountSortingOutputLine(DataParts<String> outputParts, String dataType, String outputFile) throws IOException {
        List<String> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        Map<String, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each element
        for (String element : parts) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Sort the elements by count and then by natural order using a custom Comparator
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(new CountComparator<>());

        // Calculate the total number of elements
        int totalElements = parts.size();

        // Output the sorted elements with count and percentage

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                for (Map.Entry<String, Integer> entry : sortedEntries) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    double percentage = (double) count / totalElements * 100;
                    out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
                }
            }
        } else {
            System.out.print(result);
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                String element = entry.getKey();
                int count = entry.getValue();
                double percentage = (double) count / totalElements * 100;
                System.out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
            }
        }

    }

    private static void displayCountSortingOutputWord(DataParts<String> outputParts, String dataType, String outputFile) throws IOException {
        List<String> parts = outputParts.getParts();
        String result = String.format("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        Map<String, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each element
        for (String element : parts) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Sort the elements by count and then by natural order using a custom Comparator
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(new CountComparator<>());

        // Calculate the total number of elements
        int totalElements = parts.size();

        // Output the sorted elements with count and percentage

        if (outputFile != null) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
                out.print(result);
                for (Map.Entry<String, Integer> entry : sortedEntries) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    double percentage = (double) count / totalElements * 100;
                    out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
                }
            }
        } else {
            System.out.print(result);
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                String element = entry.getKey();
                int count = entry.getValue();
                double percentage = (double) count / totalElements * 100;
                System.out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
            }
        }

    }

    private static class CountComparator<T extends Comparable<T>> implements Comparator<Map.Entry<T, Integer>> {
        @Override
        public int compare(Map.Entry<T, Integer> entry1, Map.Entry<T, Integer> entry2) {
            int countComparison = entry1.getValue().compareTo(entry2.getValue());
            if (countComparison != 0) {
                return countComparison; // Sort by count in ascending order
            }
            return entry1.getKey().compareTo(entry2.getKey()); // Sort by key in natural order
        }
    }
}

