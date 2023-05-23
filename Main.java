package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {

        String dataType = null;
        try {
            dataType = CommandLineParser.parseDataTypeArgument(args);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // TODO: Perform any additional cleanup or logging here if needed
            System.exit(1); // Terminate the program with a non-zero status code
        }

        InputParts<Object> inputParts = InputReader.readInput(dataType);
        OutputParts<Object> outputParts = new OutputParts<>(new ArrayList<>());
        InputProcessor.processInput(inputParts, outputParts, dataType);
        OutputFormatter.displayOutput(outputParts, dataType);
    }
}
