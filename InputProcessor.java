package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    public static void processInput(InputParts<Object> inputParts, OutputParts<Object> outputParts, String dataType) {
        List<Object> parts = inputParts.getParts();
        switch (dataType) {
            case "long", "sortItOut" -> {
                List<Long> longList = new ArrayList<>();
                for (Object input : parts) {
                    if (input instanceof String) {
                        String[] tokens = ((String) input).split("\\s+");
                        for (String token : tokens) {
                            try {
                                long number = Long.parseLong(token);
                                longList.add(number);
                            } catch (NumberFormatException e) {
                                System.out.println("Exception: " + e);
                            }
                        }
                    }
                }
                outputParts.setParts(longList);
            }
            case "line" -> {
                // No further processing needed for line dataType
                outputParts.setParts(parts);
            }
            case "word" -> {
                List<String> wordList = new ArrayList<>();
                for (Object input : parts) {
                    if (input instanceof String) {
                        String[] words = ((String) input).split("\\s+");
                        wordList.addAll(Arrays.asList(words));
                    }
                }
                outputParts.setParts(wordList);
            }
            default -> {
                // No further processing needed for default dataType
            }
        }
    }
}