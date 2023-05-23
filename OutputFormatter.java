package sorting;

import java.util.*;

public class OutputFormatter {
    public static void displayOutput(OutputParts<Object> outputParts, String dataType) {
        switch (dataType) {
            case "long" -> displayLongOutput(outputParts);
            case "line" -> displayLineOutput(outputParts);
            case "word" -> displayWordOutput(outputParts);
            case "sortItOut" -> displaySortIntegersOutput(outputParts);
            default -> displayDefaultOutput(outputParts, dataType);
        }
    }

    private static void displayLongOutput(OutputParts<Object> outputParts) {
        List<Long> longList = new ArrayList<>();
        for (Object input : outputParts.getParts()) {
            if (input instanceof Long) {
                longList.add((Long) input);
            }
        }
        long max = Collections.max(longList);
        long count = Collections.frequency(longList, max);
        int percentage = (int) Math.round((double) count / longList.size() * 100);

        System.out.printf("Total numbers: %d.\n", longList.size());
        System.out.printf("The greatest number: %d (%d time(s), %d%%).\n", max, count, percentage);
    }

    private static void displayLineOutput(OutputParts<Object> outputParts) {
        List<String> lineList = new ArrayList<>();
        for (Object input : outputParts.getParts()) {
            if (input instanceof String) {
                lineList.addAll(Arrays.asList(((String) input).split("~")));
            }
        }
        int max = 0;
        String longestLine = "";
        for (String line : lineList) {
            if (line.length() > max) {
                max = line.length();
                longestLine = line;
            }
        }
        int count = Collections.frequency(lineList, longestLine);
        int percentage = (int) Math.round((double) count / lineList.size() * 100);
        System.out.printf("Total lines: %d.\n", lineList.size());
        System.out.printf("The longest line:\n%s\n(%d time(s), %d%%).\n", longestLine, count, percentage);
    }

    private static void displayWordOutput(OutputParts<Object> outputParts) {
        List<String> wordList = new ArrayList<>();
        for (Object input : outputParts.getParts()) {
            if (input instanceof String) {
                wordList.add((String) input);
            }
        }

        int max = 0;
        String longestWord = "";
        for (String word : wordList)
        {
            if (word.length() > max) {
                max = word.length();
                longestWord = word;
            }
        }
        int count = Collections.frequency(wordList, longestWord);
        int percentage = (int) Math.round((double) count / wordList.size() * 100);
        System.out.printf("Total words: %d.\n", wordList.size());
        System.out.printf("The longest word: %s (%d time(s), %d%%).\n", longestWord, count, percentage);
    }

    private static void displaySortIntegersOutput(OutputParts<Object> outputParts) {
        List<Long> longList = new ArrayList<>();
        for (Object input : outputParts.getParts()) {
            if (input instanceof Long) {
                longList.add((Long) input);
            }
        }

        Collections.sort(longList);

        System.out.printf("Total numbers: %d.\n", longList.size());
        System.out.print("Sorted data: ");
        for (Long number : longList) {
            System.out.print(number + " ");
        }
    }

    private static void displayDefaultOutput(OutputParts<Object> outputParts, String dataType) {
        Map<Object, Integer> freqMap = new HashMap<>();
        for (Object input : outputParts.getParts()) {
            if (freqMap.containsKey(input)) {
                freqMap.put(input, freqMap.get(input) + 1);
            } else {
                freqMap.put(input, 1);
            }
        }
        Object max = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        int count = freqMap.get(max);
        int percentage = (int) Math.round((double) count / outputParts.getParts().size() * 100);
        System.out.printf("Total %s: %d.\n", outputParts.getParts().size() == 1 ? "item" : "items", outputParts.getParts().size());
        System.out.printf("The greatest %s: %s (%d time(s), %d%%).\n", dataType, max.toString(), count, percentage);
    }
}