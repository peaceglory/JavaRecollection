package sources.algorithms.misc;

import java.util.Arrays;

/**
 * Created by mman on 04.03.17.
 */
public class RemoveDuplicates {

    public static int[] removeDuplicatesFromArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }

        Arrays.sort(arr);

        int duplicatesFound = 0;
        int[] tmpArr = new int[arr.length];
        int prev = arr[0];
        int tmpIndex = 0;
        tmpArr[tmpIndex++] = prev;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev) {
                tmpArr[tmpIndex++] = arr[i];
            } else {
                duplicatesFound++;
            }
            prev = arr[i];
        }

        int finalSize = arr.length - duplicatesFound;
        int[] finalArr = new int[finalSize];
        for (int i = 0; i < finalSize; i++) {
            finalArr[i] = tmpArr[i];
        }

        return finalArr;
    }
}
