package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {

        String dataType = "";
        if (args.length > 1 && args[0].equals("-dataType")) {
            dataType = args[1];
        }
        boolean validArg = (dataType.equals("long") || dataType.equals("line") || dataType.equals("word"));
        if (!validArg) {
            System.out.printf("Data type argument \"%s\" not found or not valid.", dataType);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        InputParts<Object> inputParts = new InputParts<>(new ArrayList<>());
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (dataType) {
                case "long" -> {
                    try {
                        String[] parts = input.split("\\s+");
                        for (String part : parts) {
                            try {
                                long number = Long.parseLong(part);
                                inputParts.getParts().add(number);
                            } catch (NumberFormatException e) {
                                System.out.println("Exception: " + e);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Exception: " + e);
                    }
                }
                case "line" -> {
                    inputParts.getParts().add(input);
                }
                case "word" -> {
                    String[] words = input.split("\\s+");
                    inputParts.getParts().addAll(Arrays.asList(words));
                }
                default -> {
                    try {
                        long number = Long.parseLong(input);
                        inputParts.getParts().add(number);
                    } catch (NumberFormatException e1) {
                        inputParts.getParts().add(input);
                    }
                }
            }
        }
        switch (dataType) {
            case "long" -> displayLongOutput(inputParts);
            case "line" -> displayLineOutput(inputParts);
            case "word" -> displayWordOutput(inputParts);
            default -> displayDefaultOutput(inputParts, dataType);
        }
    }

    private static void displayLongOutput(InputParts<Object> inputParts) {
        List<Long> longList = new ArrayList<>();
        for (Object input : inputParts.getParts()) {
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

    private static void displayLineOutput(InputParts<Object> inputParts) {
        List<String> lineList = new ArrayList<>();
        for (Object input : inputParts.getParts()) {
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

    private static void displayWordOutput(InputParts<Object> inputParts) {
        List<String> wordList = new ArrayList<>();
        for (Object input : inputParts.getParts()) {
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

    private static void displayDefaultOutput(InputParts<Object> inputParts, String dataType) {
        Map<Object, Integer> freqMap = new HashMap<>();
        for (Object input : inputParts.getParts()) {
            if (freqMap.containsKey(input)) {
                freqMap.put(input, freqMap.get(input) + 1);
            } else {
                freqMap.put(input, 1);
            }
        }
        Object max = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        int count = freqMap.get(max);
        int percentage = (int) Math.round((double) count / inputParts.getParts().size() * 100);
        System.out.printf("Total %s: %d.\n", inputParts.getParts().size() == 1 ? "item" : "items", inputParts.getParts().size());
        System.out.printf("The greatest %s: %s (%d time(s), %d%%).\n", dataType, max.toString(), count, percentage);
    }
}
