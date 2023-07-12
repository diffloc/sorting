package sorting;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws IOException {
        Map<String, String> arguments = CommandLineParser.parseArguments(args);
        String dataType = arguments.getOrDefault("-dataType", "");
        String sortingType = arguments.getOrDefault("-sortingType", "natural");
        String inputFile = arguments.getOrDefault("-inputFile", null);
        String outputFile = arguments.getOrDefault("-outputFile", null);

        DataParts<String> inputParts = InputReader.readInput(inputFile);

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
                OutputFormatter.displayOutputLong(outputParts, sortingType, outputFile);
            }
            case "line" -> {
                DataParts<String> outputParts = new DataParts<>(new ArrayList<>());
                InputProcessor.processInputLine(inputParts, outputParts);
                OutputFormatter.displayOutputLine(outputParts, sortingType, outputFile);
            }
            case "word" -> {
                DataParts<String> outputParts = new DataParts<>(new ArrayList<>());
                InputProcessor.processInputWord(inputParts, outputParts);
                OutputFormatter.displayOutputWord(outputParts, sortingType, outputFile);
            }
            default -> throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
    }
}

