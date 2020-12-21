package postjava6.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Streams3 {

    /**
     * Given a list of strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters.
     */
    public List<String> search(List<String> list) {
        return list.stream()
                .filter(str -> str.length() == 3)
                .filter(str -> str.startsWith("a"))
                .collect(Collectors.toList());
    }

    /**
     * Write a method that returns the average of a list of integers.
     */
    public Double average(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }

    /**
     * Write a method that converts all strings in a list to their upper case.
     */
    public List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Write a method that returns a comma-separated string based on a given list of integers.
     * Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
     * For example, if the input list is (3,44), the output should be 'o3,e44'.
     */
    public String getString(List<Integer> list) {
//        return getStringWithMap(list);
        return getStringWithReduce(list);
    }

    private String getStringWithMap(List<Integer> list) {
        return list.stream()
                .map(i -> {
                    if (isEven(i)) {
                        return "e" + i;
                    }
                    return "o" + i;
                })
                .collect(Collectors.joining(","));
    }

    private String getStringWithReduce(List<Integer> list) {
        return list.stream()
                .map(i -> Integer.toString(i))
                .reduce("", (partial, element) -> {
                    final String pref = isEven(Integer.parseInt(element)) ? "e" : "o";
                    if (!"".equals(partial)) {
                        return partial + "," + pref + element;
                    }
                    return pref + element;
                });
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}

