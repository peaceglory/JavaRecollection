package algorithms.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Implement the uniqueNames method. When passed two arrays of names,
 * it will return an array containing the names that appear in either or both arrays.
 * The returned array should have no duplicates.
 * For example, calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'}, new String[]{'Olivia', 'Sophia', 'Emma'})
 * should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 */
public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        final Set<String> hNames1 = new HashSet<>(Arrays.asList(names1));
        final Set<String> hNames2 = new HashSet<>(Arrays.asList(names2));

        hNames1.addAll(hNames2);

        return hNames1.toArray(new String[0]);
    }

    public static String[] uniqueNamesStreams(String[] names1, String[] names2) {
        final Stream<String> stream1 = Arrays.stream(names1);
        final Stream<String> stream2 = Arrays.stream(names2);

        return Stream.concat(stream1, stream2)
                .distinct()
                .toArray(String[]::new);
    }

    @Test
    void testMergeNames() {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};

        final String[] uniqueNames = uniqueNames(names1, names2);

        final Set<String> expected = new HashSet<>(Arrays.asList("Ava", "Emma", "Olivia", "Sophia"));

        assertEquals(expected, new HashSet<>(Arrays.asList(uniqueNames)));
    }

    @Test
    void testMergeNamesWithStream() {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};

        final String[] uniqueNames = uniqueNamesStreams(names1, names2);

        final Set<String> expected = new HashSet<>(Arrays.asList("Ava", "Emma", "Olivia", "Sophia"));

        assertEquals(expected, new HashSet<>(Arrays.asList(uniqueNames)));
    }
}
