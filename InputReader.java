package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    public static InputParts<Object> readInput(String dataType) {
        // Implementation to read input using a Scanner
        // Return an InputParts object containing the parsed input

        Scanner scanner = new Scanner(System.in);
        InputParts<Object> inputParts = new InputParts<>(new ArrayList<>());
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            inputParts.getParts().add(input);
        }
        return inputParts;
    }
}