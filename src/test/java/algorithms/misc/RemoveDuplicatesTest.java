package algorithms.misc;


import org.junit.jupiter.api.Test;

import utils.ArrayUtils;

/**
 * Created by mman on 04.03.17.
 */
class RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicatesFromArray() {
        int[] arr = { 5, 1, 2, 5, 1, 5, 3, 2 };
        ArrayUtils.printArray(arr);

        int[] noDupsArr = RemoveDuplicates.removeDuplicatesFromArray(arr);
        ArrayUtils.printArray(noDupsArr);
    }
}
