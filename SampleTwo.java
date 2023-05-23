package sorting;

// More organized approach
//
//         src/sorting/sorters/Sorter.java
//         package sorting.sorters;
//
// import java.util.Scanner;
//
// public abstract class Sorter {
//     int count;
//     Scanner scanner;
//
//     public Sorter() {
//         this.count = 0;
//         scanner = new Scanner(System.in);
//     }
//
//     public abstract void read();
//     public abstract void sort();
// }
// src/sorting/Main.java
//         package sorting;
//
//         import sorting.logic.ArgsParser;
//         import sorting.sorters.Sorter;
//
// public class Main {
//     public static void main(final String[] args) {
//         Sorter sorter = ArgsParser.parseArgs(args);
//         sorter.read();
//         sorter.sort();
//         System.out.println(sorter.toString());
//     }
// }
// src/sorting/logic/ArgsParser.java
//         package sorting.logic;
//
//         import sorting.sorters.*;
//
// public class ArgsParser {
//     public static Sorter parseArgs(String[] args) {
//         for (String arg : args) {
//             if (arg.equals("-sortIntegers")) {
//                 return new IntegerSorter();
//             }
//         }
//         for (int i = 0; i < args.length; i++) {
//             if (args[i].equals("-dataType")) {
//                 if (i == (args.length - 1)) {
//                     return new WordSorter();
//                 } else {
//                     return parseDataType(args[i + 1]);
//                 }
//             }
//         }
//         throw new IllegalArgumentException();
//     }
//
//     public static Sorter parseDataType(String arg) {
//         switch (arg) {
//             case "long":
//                 return new LongSorter();
//             case "word":
//                 return new WordSorter();
//             case "line":
//                 return new LineSorter();
//             default:
//                 throw new IllegalArgumentException();
//         }
//     }
// }
// src/sorting/sorters/IntegerSorter.java
//         package sorting.sorters;
//
//         import java.util.ArrayList;
//         import java.util.Collections;
//         import java.util.List;
//
// public class IntegerSorter extends Sorter {
//     List<Integer> numbers;
//
//     public IntegerSorter() {
//         this.numbers = new ArrayList<>();
//     }
//
//     @Override
//     public void read() {
//         while (scanner.hasNextInt()) {
//             count++;
//             numbers.add(scanner.nextInt());
//         }
//     }
//
//     @Override
//     public void sort() {
//         Collections.sort(numbers);
//     }
//
//     @Override
//     public String toString() {
//         StringBuilder output = new StringBuilder("Total numbers: " + count + ".\n" +
//                 "Sorted data: ");
//         for (int i = 0; i < numbers.size(); i++) {
//             if (i == (numbers.size() - 1)) {
//                 output.append(numbers.get(i));
//             } else {
//                 output.append(numbers.get(i)).append(" ");
//             }
//         }
//         return output.toString();
//     }
// }
// src/sorting/sorters/LineSorter.java
//         package sorting.sorters;
//
//         import java.util.ArrayList;
//         import java.util.List;
//
// public class LineSorter extends Sorter {
//     private String longestLine;
//     private int longestLineCount;
//     private double percentage;
//     private List<String> lines;
//
//     public LineSorter() {
//         longestLineCount = 0;
//         longestLine = "";
//         lines = new ArrayList<>();
//     }
//
//     @Override
//     public void read() {
//         while (scanner.hasNextLine()) {
//             count++;
//             lines.add(scanner.nextLine());
//         }
//     }
//
//     @Override
//     public void sort() {
//         longestLine = lines.get(0);
//         for (String s : lines) {
//             if (s.length() > longestLine.length()) {
//                 longestLine = s;
//                 longestLineCount = 1;
//             } else if (s.length() == longestLine.length()) {
//                 longestLineCount++;
//             }
//         }
//         percentage = (double) longestLineCount / count * 100;
//     }
//
//     @Override
//     public String toString() {
//         return "Total lines: " + count + ".\n" +
//                 "The longest line: \n" + longestLine + "\n(" + longestLineCount +
//                 " time(s), " + String.format("%.0f", percentage) + "%).";
//     }
// }
// src/sorting/sorters/LongSorter.java
//         package sorting.sorters;
//
//         import java.util.ArrayList;
//         import java.util.List;
//
// public class LongSorter extends Sorter {
//     private List<Long> numbers;
//     private long greatestNumber;
//     private int greatestNumberCount;
//     private double percentage;
//
//     public LongSorter() {
//         numbers = new ArrayList<>();
//         greatestNumberCount = 0;
//     }
//
//     @Override
//     public void read() {
//         while (scanner.hasNextLong()) {
//             count++;
//             numbers.add(scanner.nextLong());
//         }
//     }
//
//     @Override
//     public void sort() {
//         greatestNumber = numbers.get(0);
//         for (Long number : numbers) {
//             if (number > greatestNumber) {
//                 greatestNumberCount = 1;
//                 greatestNumber = number;
//             } else if (number == greatestNumber) {
//                 greatestNumberCount++;
//             }
//         }
//         percentage = (double) greatestNumberCount / count * 100;
//     }
//
//     @Override
//     public String toString() {
//         return "Total numbers: " + count + ".\n" +
//                 "The greatest number: " + greatestNumber + " (" + greatestNumberCount +
//                 " time(s), " + String.format("%.0f", percentage) + "%).";
//     }
// }
// src/sorting/sorters/WordSorter.java
//         package sorting.sorters;
//
//         import java.util.ArrayList;
//         import java.util.List;
//
// public class WordSorter extends Sorter {
//     private String longestWord;
//     private int longestWordCount;
//     private double percentage;
//     private List<String> words;
//
//     public WordSorter() {
//         longestWordCount = 0;
//         longestWord = "";
//         words = new ArrayList<>();
//     }
//
//     @Override
//     public void read() {
//         while (scanner.hasNext()) {
//             count++;
//             words.add(scanner.next());
//         }
//     }
//
//     @Override
//     public void sort() {
//         longestWord = words.get(0);
//         for (String s : words) {
//             if (s.length() > longestWord.length()) {
//                 longestWord = s;
//                 longestWordCount = 1;
//             } else if (s.length() == longestWord.length()) {
//                 longestWordCount++;
//             }
//         }
//         percentage = (double) longestWordCount / count * 100;
//     }
//
//     @Override
//     public String toString() {
//         String percent = String.format("%.0f", percentage);
//         return "Total words: " + count + ".\nThe longest word: "
//                 + longestWord + " (" + longestWordCount + " time(s), " + percent + "%).";
//     }
// }