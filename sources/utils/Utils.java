package sources.utils;

import sources.reflection.ArrayGrower;
import sources.reflection.ObjectAnalyzer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

    public static void traverseDirectoryBFS(File dir) {
        ensureDirInput(dir);

        Queue<File> q = new LinkedList<>();
        q.add(dir);

        while (!q.isEmpty()) {
            File f = q.poll();
            System.out.println(f.getName());
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory() && !file.getName().startsWith(".")) {
                    q.add(file);
                }
            }
        }
    }

    public static void traverseDirectoryDFS(File dir) {
        ensureDirInput(dir);

        Stack<File> stack = new Stack<>();
        stack.push(dir);

        while (!stack.isEmpty()) {
            File f = stack.pop();
            System.out.println(f.getName());
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory() && !file.getName().startsWith(".")) {
                    stack.add(file);
                }
            }
        }
    }

    public static <T extends Comparable> int compare(T v1, T v2, Comparator<? super T> comparator) {
        if (comparator == null) {
            if (v1.compareTo(v2) > 0) {
                return 1;
            }
            if (v1.compareTo(v2) < 0) {
                return -1;
            }
        } else {
            if (comparator.compare(v1, v2) > 0) {
                return 1;
            }
            if (comparator.compare(v1, v2) < 0) {
                return -1;
            }
        }
        return 0;
    }

    private static void ensureDirInput(File f) {
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Not a dir: " + f.getName());
        }
    }
}
