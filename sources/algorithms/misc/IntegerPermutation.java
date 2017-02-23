package sources.algorithms.misc;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mman on 22.02.17.
 */
public class IntegerPermutation {

    public static void permutations(int n) {
        int[] a = numberToArray(n);
        permutations(a, 0);
    }

    private static void permutations(int[] arr, int index) {
        if (index >= arr.length - 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutations(arr, index + 1);
            swap(arr, i, index);
        }
    }

    public static int[] numberToArray(int n) {
        Stack<Integer> stack = new Stack<>();

        do {
            int digit = n % 10;
            stack.push(digit);
            n /= 10;
        } while (n != 0);

        int[] arr = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            arr[i] = stack.pop();
        }

        return arr;
    }

    private static void swap(Object arr, int index1, int index2) {
        Class clazz = null;
        if (arr == null || !(clazz = arr.getClass()).isArray()) {
            throw new IllegalArgumentException("must be array");
        }
        Object tmp = Array.get(arr, index1);
        Array.set(arr, index1, Array.get(arr, index2));
        Array.set(arr, index2, tmp);
    }

    public static void main(String[] args) {
//        testNumberToArray();
        testPermutations();
    }

    private static void testPermutations() {
        permutations(123);
    }

    private static void testNumberToArray() {
        int[] testNumbers = new int[]{1, 12, 123, 1234, 0};

        for (int i = 0; i < testNumbers.length; i++) {
            int[] result = IntegerPermutation.numberToArray(testNumbers[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }
}
