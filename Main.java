package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
        }
        int maxValue = Collections.max(numbers);
        int countMaxValue = Collections.frequency(numbers, maxValue);
        System.out.printf("Total numbers: %d.\n", numbers.size());
        System.out.printf("The greatest number: %d (%d time(s))", maxValue, countMaxValue);
    }
}
