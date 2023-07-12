package sorting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {

    public static DataParts<String> readInput(String inputFile) throws IOException {
        DataParts<String> inputParts = new DataParts<>(new ArrayList<>());
        try (Scanner scanner = inputFile == null ? new Scanner(System.in) : new Scanner(new File(inputFile))) {
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