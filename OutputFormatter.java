package sorting;

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

    public static void displayOutputLong(DataParts<Long> outputParts, String sortingType) {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputLong(outputParts, "long");
            case "byCount" -> displayCountSortingOutputLong(outputParts, "long");
        }
    }

    public static void displayOutputLine(DataParts<String> outputParts, String sortingType) {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputLine(outputParts, "line");
            case "byCount" -> displayCountSortingOutputLine(outputParts, "line");
        }
    }

    public static void displayOutputWord(DataParts<String> outputParts, String sortingType) {
        switch (sortingType) {
            case "natural" -> displayNaturalSortingOutputWord(outputParts, "word");
            case "byCount" -> displayCountSortingOutputWord(outputParts, "word");
        }
    }

    private static void displayNaturalSortingOutputLong(DataParts<Long> outputParts, String dataType) {
        List<Long> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<Long> longList = parts.stream()
                .filter(obj -> obj instanceof Long)
                .map(obj -> (Long) obj)
                .collect(Collectors.toList());
        Collections.sort(longList);
        System.out.print("Sorted data: ");
        for (Long number : longList) {
            System.out.print(number + " ");
        }
    }

    private static void displayNaturalSortingOutputLine(DataParts<String> outputParts, String dataType) {
        List<String> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<String> lineList = parts.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .collect(Collectors.toList());
        Collections.sort(lineList);
        System.out.println("Sorted data:");
        for (String line : lineList) {
            System.out.println(line);
        }
    }

    private static void displayNaturalSortingOutputWord(DataParts<String> outputParts, String dataType) {
        List<String> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

        List<String> wordList = parts.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .collect(Collectors.toList());
        Collections.sort(wordList);
        System.out.print("Sorted data: ");
        for (String word : wordList) {
            System.out.print(word + " ");
        }
    }

    private static void displayCountSortingOutputLong(DataParts<Long> outputParts, String dataType) {
        List<Long> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

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

        // Display the sorted elements with count and percentage
        for (Map.Entry<Long, Integer> entry : sortedEntries) {
            Long element = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalElements * 100;
            System.out.printf("%d: %d time(s), %.0f%%\n", element, count, percentage);
        }
    }

    private static void displayCountSortingOutputLine(DataParts<String> outputParts, String dataType) {
        List<String> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

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

        // Display the sorted elements with count and percentage
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String element = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalElements * 100;
            System.out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
        }
    }

    private static void displayCountSortingOutputWord(DataParts<String> outputParts, String dataType) {
        List<String> parts = outputParts.getParts();
        System.out.printf("Total %s: %d.\n", getDataTypeLabel(dataType), parts.size());

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

        // Display the sorted elements with count and percentage
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String element = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalElements * 100;
            System.out.printf("%s: %d time(s), %.0f%%\n", element, count, percentage);
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

