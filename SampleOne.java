

package sorting;

// Example showing Strategy Pattern and Interfaces
//
// import java.util.*;
// import java.util.stream.Collectors;
// import java.util.stream.LongStream;
//
// interface Algorithm<T> {
//     List<T> sort(List<T> arr);
// }
//
// class Merge<T> implements Algorithm<T>{
//
//     List<List<T>> arrHelper = new ArrayList<>();
//     Comparator<T> comparator;
//
//     Merge(Comparator<T> comparator){
//         this.comparator = comparator;
//     }
//
//     @Override
//     public List<T> sort(List<T> arr) {
//         arr.forEach(elem ->  arrHelper.add(Arrays.asList((T)elem)));
//         while(arrHelper.size() != 1){
//             for (int i = 0; i < arrHelper.size()-1; i++) {
//                 arrHelper.set(i,merge(arrHelper.get(i),arrHelper.get(i+1)));
//                 arrHelper.remove(i+1);
//             }
//         }
//
//         return arrHelper.get(0);
//
//     }
//
//     List <T> merge(List<T> arr1, List<T> arr2){
//         int n1 = arr1.size();
//         int n2 = arr2.size();
//         List<T> newArr = new ArrayList<>();
//         int i =0; int j =0;
//
//         for (int k = 0; k < n1 + n2; k++) {
//             if (i == n1) {
//                 newArr.addAll(arr2.subList(j,n2));
//                 break;
//             } else if (j == n2) {
//                 newArr.addAll(arr1.subList(i,n1));
//                 break;
//             } else if (comparator.compare(arr1.get(i),arr2.get(j))<0){
//                 newArr.add(arr1.get(i));
//                 i++;
//             } else {
//                 newArr.add(arr2.get(j));
//                 j++;
//             }
//
//         }
//         return newArr;
//     }
// }
//
// abstract class Sorter<T> extends ArrayList<T> {
//     public static final Scanner scanner = new Scanner(System.in);
//
//     private Algorithm<T> algorithm;
//
//     Sorter() {
//         fill();
//     }
//     abstract Sorter<T> fill();
//
//     void setAlgorithm(Algorithm<T> algorithm){
//         this.algorithm = algorithm;
//     }
//
//     List<T> sort(){
//         return this.algorithm.sort(this);
//     }
//
//     abstract T getMax();
//
//     int getFrequency() {
//         return Collections.frequency(this, getMax());
//     }
//
//     int getFrequencyPerc() {
//         return getFrequency() * 100 / this.size();
//     }
//
//     abstract void printInfo();
//
//     abstract void printSorted();
//
// }
//
// class LongSorter<T extends Long> extends Sorter {
//     LongSorter<T> fill() {
//         setAlgorithm(new Merge<T>(Long::compareTo));
//         while (scanner.hasNextLong()) {
//             this.add(scanner.nextLong());
//         }
//         return this;
//     }
//
//     Long getMax() {
//         return Collections.max(this, Long::compareTo);
//     }
//
//     void printInfo() {
//         System.out.printf("Total numbers: %d.\nThe greatest number: %d (%d time(s), %d%%).\n", this.size(), getMax(), getFrequency(), getFrequencyPerc());
//     }
//
//     void printSorted() {
//         System.out.printf("Total numbers: %d.\nSorted data: %s\n", this.size(), sort().stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" ")));
//     }
// }
//
// abstract class StringSorter<T extends String> extends Sorter {
//     protected Comparator<String> comparator = (String a, String b) -> a.length() - b.length() == 0 ? a.compareTo(b) : a.length() - b.length();
//     String getMax() {
//         //if equals then soft alphabetically
//         return (String) Collections.max(this, comparator);
//     }
// }
//
// class LineSorter<T> extends StringSorter {
//     LineSorter<T> fill() {
//         setAlgorithm(new Merge<T>(comparator));
//         while (scanner.hasNextLine()) {
//             this.add(scanner.nextLine());
//         }
//         return this;
//     }
//
//     void printInfo() {
//         System.out.printf("Total lines: %d.\nThe longest line:\n%s\n(%d time(s), %d%%).\n", this.size(), getMax(), getFrequency(), getFrequencyPerc());
//     }
//
//     void printSorted() {
//         System.out.printf("Total numbers: %d.\nSorted data: %s\n", this.size(), String.join(" ", (Iterable<? extends CharSequence>) sort()));
//     }
// }
//
// class WordSorter<T> extends StringSorter {
//     WordSorter<T> fill() {
//         while (scanner.hasNext()) {
//             this.add(scanner.next());
//         }
//         return this;
//     }
//
//     void printInfo() {
//         System.out.printf("Total words: %d.\nThe longest word: %s (%d time(s), %d%%).\n", this.size(), getMax(), getFrequency(), getFrequencyPerc());
//     }
//
//     void printSorted() {
//         System.out.printf("Total numbers: %d.\nSorted data: %s\n", this.size(), String.join(" ", (Iterable<? extends CharSequence>) sort()));
//     }
//
// }
//
// class SortingTool {
//     private Sorter sorter;
//
//     public void setSorter(Sorter sorter) {
//         this.sorter = sorter;
//     }
//
//     public Sorter setSorterByType(String type) {
//         switch (type.toLowerCase()) {
//             case "long":
//                 setSorter(new LongSorter());
//                 break;
//             case "line":
//                 setSorter(new LineSorter());
//                 break;
//             default:
//                 setSorter(new WordSorter());
//         }
//         return sorter;
//     }
// }
//
// public class Main {
//     public static void main(final String[] args) {
//         SortingTool st = new SortingTool();
//         if (Arrays.asList(args).contains("-sortIntegers")){
//             st.setSorterByType("long").printSorted();
//         } else if (args.length > 1 && args[0].equals("-dataType")) {
//             st.setSorterByType(args[1]).printInfo();
//         } else {
//             System.out.println("Error: wrong number of arguments");
//         }
//     }
// }

//    Long max = arr.stream().max(Long::compare).orElse(0L);
//    Long counter = arr.stream().reduce(0L,(x, b) -> x += (b.equals(max) ? 1: 0));
//    Merge<Integer> sorter = new Merge<>(Integer::compareTo);
//    List<Integer> list = Arrays.asList(-4, 2,92,42,-54,33,12,14,12,12);
//    System.out.println(sorter.sort(list).toString());