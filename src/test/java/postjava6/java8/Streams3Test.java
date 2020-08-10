package postjava6.java8;


import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Streams3Test {
    private Streams3 classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new Streams3();
    }

    @AfterEach
    void tearDown() {
        classUnderTest = null;
    }

    @Test
    void average() {
        final Double average = classUnderTest.average(ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertEquals(5.5, average.doubleValue());
    }

    @Test
    void upperCase() {
        final List<String> strings =
                classUnderTest.upperCase(ImmutableList.of("heythere", "Whatsup", "wOw", "HOORAAY"));

        final List<String> expected = ImmutableList.of("HEYTHERE", "WHATSUP", "WOW", "HOORAAY");

        assertEquals(4, strings.size());
        assertEquals(expected, strings);
    }

    @Test
    void search() {
        final List<String> list = ImmutableList.of("Aha", "aham", "ace", "bconnect", "you", "are", "ate");
        final List<String> strings = classUnderTest.search(list);

        assertFalse(strings.isEmpty());
        assertEquals(3, strings.size());
        assertEquals(ImmutableList.of("ace", "are", "ate"), strings);
    }

    @Test
    void getString() {
        final String string = classUnderTest.getString(ImmutableList.of(3, 8, 100, 35, 44, 12, 28));
        final String expected = "o3,e8,e100,o35,e44,e12,e28";

        assertEquals(expected, string);
    }
}