package sources.utils;

import sources.reflection.ArrayGrower;
import sources.reflection.ObjectAnalyzer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Created by mman on 10.12.16.
 */
public class Utils {

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

    public static String toString(Object o) {
        return new ObjectAnalyzer().toString(o);
    }

    public static Integer[] createRandomIntegerArray(int size) {
        Stream<Integer> ints = Stream.generate(() -> new Random().nextInt(1000)).limit(size);
        return ints.toArray(Integer[]::new);
    }

    public static String[] createRandomStringArray(int size) {
        Path filepath = Paths.get("/media/mman/Data/Big Files/big.txt");
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(filepath);
        } catch (IOException e) {
            return new String[]{"This", "is", "emergency", "array --> ", e.getMessage()};
        }
        String content = new String(bytes, StandardCharsets.UTF_8);
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
