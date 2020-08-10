package datastructures.misc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FailSafePlayTest {
    private FailSafePlay classUnderTest;
    private ConcurrentMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new ConcurrentHashMap<>();
        map.put("1", "Windows Phone: " + "1".hashCode());
        map.put("2", "iPhone: " + "2".hashCode());
        map.put("3", "HTC: " + "3".hashCode());

        classUnderTest = new FailSafePlay();
    }

    @AfterEach
    void tearDown() {
        classUnderTest = null;
        map.clear();
        map = null;
    }

    @Test
    void givenConcurrentHashMap_whenIterateAndAddValue_thenExpectNewValuePrinted() {
        final List<String> expectedPrinted = Arrays.asList("1", "2", "3", "Samsung");
        final List<String> keysPrinted = classUnderTest.iterateAndModify(map, "Samsung", "S5: " + "Samsung".hashCode());

        Assertions.assertEquals(expectedPrinted, keysPrinted);
    }

    @Test
    void givenConcurrentHashMap_whenIterateAndAddValue_thenExpectNewValueNotPrinted() {
        System.out.println("This time S5 will not be displayed since hashCode is " + "0".hashCode() + " and iterator has already passed by that bucket");

        final List<String> expectedPrinted = Arrays.asList("1", "2", "3");

        final List<String> keysPrinted = classUnderTest.iterateAndModify(map, "0", "S5: " + "0".hashCode());

        Assertions.assertEquals(expectedPrinted, keysPrinted);
    }
}