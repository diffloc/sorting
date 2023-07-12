package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Map<String, String> arguments = CommandLineParser.parseArguments(args);
        String dataType = arguments.getOrDefault("-dataType", "");
        String sortingType = arguments.getOrDefault("-sortingType", "natural");
        DataParts<String> inputParts = InputReader.readInput();

        if (dataType.isEmpty()) {
            System.out.println("No data type defined!");
            return;
        }

        if (sortingType.isEmpty()) {
            System.out.println("No sorting type defined!");
            return;
        }

        switch (dataType) {
            case "long" -> {
                DataParts<Long> outputParts = new DataParts<>(new ArrayList<>());
                InputProcessor.processInputLong(inputParts, outputParts);
                OutputFormatter.displayOutputLong(outputParts, sortingType);
            }
            case "line" -> {
                DataParts<String> outputParts = new DataParts<>(new ArrayList<>());
                InputProcessor.processInputLine(inputParts, outputParts);
                OutputFormatter.displayOutputLine(outputParts, sortingType);
            }
            case "word" -> {
                DataParts<String> outputParts = new DataParts<>(new ArrayList<>());
                InputProcessor.processInputWord(inputParts, outputParts);
                OutputFormatter.displayOutputWord(outputParts, sortingType);
            }
            default -> throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
    }
}

