package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {

    public static DataParts<String> readInput() {
        DataParts<String> inputParts = new DataParts<>(new ArrayList<>());
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                inputParts.getParts().add(input);
            }
        }
        return inputParts;
    }
}