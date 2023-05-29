package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {

    public static DataParts<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        DataParts<String> inputParts = new DataParts<>(new ArrayList<>());
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