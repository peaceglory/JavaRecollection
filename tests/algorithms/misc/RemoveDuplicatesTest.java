package tests.algorithms.misc;


import org.testng.annotations.Test;
import sources.algorithms.misc.RemoveDuplicates;
import sources.utils.ArrayUtils;

/**
 * Created by mman on 04.03.17.
 */
public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicatesFromArray() {
        int[] arr = { 5, 1, 2, 5, 1, 5, 3, 2 };
        ArrayUtils.printArray(arr);

        int[] noDupsArr = RemoveDuplicates.removeDuplicatesFromArray(arr);
        ArrayUtils.printArray(noDupsArr);
    }
}
