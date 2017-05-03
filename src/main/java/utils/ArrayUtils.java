package utils;

import reflection.ArrayGrower;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static utils.StringUtils.getBigString;

/**
 * Created by mman on 04.03.17.
 */
public class ArrayUtils {

    public static Object growArray(Object arr) {
        return ArrayGrower.growArray(arr);
    }

    public static void printArray(Object arr) {
        if (Objects.nonNull(arr)) {
            Class<?> clazz = arr.getClass();
            if (clazz.isArray()) {
                int l = Array.getLength(arr);
                for (int i = 0; i < l; i++) {
                    if (i == 0) {
                        System.out.print("[");
                    }
                    System.out.print(Array.get(arr, i));

                    if (i == l - 1) {
                        System.out.println("]");
                    } else {
                        System.out.print(", ");
                    }

                }
            }
        }
    }

    public static Integer[] createRandomIntegerArray(int size) {
        Stream<Integer> ints = Stream.generate(() -> new Random().nextInt(1000)).limit(size);
        return ints.toArray(Integer[]::new);
    }

    public static String[] createRandomStringArray(int size) {
        String content = getBigString();
        String[] strArray = content.split("[\\P{L}]+");
        ThreadLocalRandom r = ThreadLocalRandom.current();
        strArray = Arrays.copyOfRange(strArray,
                r.nextInt(0, strArray.length/2),
                r.nextInt(strArray.length/2, strArray.length));
        if (size < strArray.length) {
            strArray = Arrays.copyOfRange(strArray, 0, size);
        }
        return strArray;
    }
}
