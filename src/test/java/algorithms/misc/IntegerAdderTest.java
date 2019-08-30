package algorithms.misc;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerAdderTest {
    private IntegerAdder classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new IntegerAdder();
    }

    @AfterEach
    void tearDown() {
        classUnderTest = null;
    }

    @Test
    void addTwoNumbers_EqualDigits() {
        final ImmutableList<Integer> list1 = ImmutableList.of(2, 4, 3);
        final ImmutableList<Integer> list2 = ImmutableList.of(5, 6, 4);

        final List<Integer> outcome = classUnderTest.add(list1, list2);

        assertEquals(ImmutableList.of(7, 0, 8), outcome);
    }

    @Test
    void addTwoNumbers_FirstListBigger() {
        final ImmutableList<Integer> list1 = ImmutableList.of(6, 8, 9, 1);
        final ImmutableList<Integer> list2 = ImmutableList.of(2, 9, 3);

        final List<Integer> outcome = classUnderTest.add(list1, list2);

        assertEquals(ImmutableList.of(8, 7, 3, 2), outcome);
    }

    @Test
    void addTwoNumbers_SecondListBigger() {
        final ImmutableList<Integer> list1 = ImmutableList.of(9, 9, 9, 9);
        final ImmutableList<Integer> list2 = ImmutableList.of(9, 9, 9, 9, 9, 9);

        final List<Integer> outcome = classUnderTest.add(list1, list2);

        assertEquals(ImmutableList.of(8, 9, 9, 9, 0, 0, 1), outcome);
    }
}