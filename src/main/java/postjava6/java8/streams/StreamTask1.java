package postjava6.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * [[Pesho, 4], [Yana, 6], [Miro, 5], [Eli, 6], [Miro, 6], [Eli, 5]]
 * Print the average mark of each student
 */
public class StreamTask1 {

    public Map<String, Double> findAverage(String[][] matrix) {
        return Arrays.stream(matrix).collect(
                Collectors.groupingBy(
                        person -> person[0],
                        Collectors.mapping(
                                arr -> Double.valueOf(arr[1]),
                                Collectors.averagingDouble(value -> value))));
    }

    @Test
    void test_findAverage() {
        final String[][] matrix = {
                {"Pesho", "4"},
                {"Yana", "6"},
                {"Miro", "5"},
                {"Eli", "6"},
                {"Gogo", "2"},
                {"Miro", "6"},
                {"Eli", "5"},
                {"Gogo", "6"}
        };

        final Map<String, Double> collect = findAverage(matrix);

        final Map<String, Double> expected = new HashMap<>(collect.size());
        expected.put("Gogo", 4.0);
        expected.put("Yana", 6.0);
        expected.put("Eli", 5.5);
        expected.put("Pesho", 4.0);
        expected.put("Miro", 5.5);

        assertEquals(expected, collect);
    }
}
