package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {

    //TODO: Use StringTokenizer or Pattern.compile() for more efficient string splitting.

    public static void processInputLong(DataParts<String> inputParts, DataParts<Long> outputParts) {
        for (String line: inputParts.getParts()) {
            String[] numbers = line.split("\\s+");
            for (String token : numbers) {
                try {
                    long number = Long.parseLong(token);
                    outputParts.getParts().add(number);
                } catch (NumberFormatException e) {
                    System.out.println("\"" + token + "\" is not a long. It will be skipped.");
                }
            }
        }
    }

    public static void processInputLine(DataParts<String> inputParts, DataParts<String> outputParts) {
        outputParts.getParts().addAll(inputParts.getParts());
    }

    public static void processInputWord(DataParts<String> inputParts, DataParts<String> outputParts) {
        List<String> wordList = new ArrayList<>();
        for (String line : inputParts.getParts()) {
            String[] words = line.split("\\s+");
            wordList.addAll(Arrays.asList(words));
        }
        outputParts.setParts(wordList);
    }
}