package postjava6.java8.streams;

import com.sun.deploy.ref.AppModel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * [[Pesho, 4], [Yana, 6], [Miro, 5], [Eli, 6], [Miro, 6], [Eli, 5]]
 * Print the average mark of each student
 */
public class StreamTask1 {

    @Test
    void findAverage() {
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

        /*
        * 1. Create a Map<String, List<String[]>>
        * 2. Process each array in the stream
        *   - map.put(arr[0], arr)
        *   - Map is now constructed
        * 3. Process each entry in the map
        *   - process each item in the value list
        *       - convert the item to number
        *   - reduce the list to an average
        * 4. A Map<String, Double> is produced as a final result.
        */
        final Map<String, Double> collect = Arrays.stream(matrix).collect(
                Collectors.groupingBy(
                        person -> person[0],
                        Collectors.mapping(
                                arr -> Integer.valueOf(arr[1]),
                                Collectors.averagingDouble(value -> value))));

        System.out.println(collect);
    }
}
