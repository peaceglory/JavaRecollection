package sources.reflection;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by mman on 02.12.16.
 */
public class ArrayGrower {

    public static Object growArray(Object arr) {
        Class clazz = null;

        if (arr == null || !(clazz = arr.getClass()).isArray()) {
            throw new IllegalArgumentException("Argument needs to be non-null array!");
        }

        Class componentType = clazz.getComponentType();
        int length = Array.getLength(arr);
        int newLength = length * 11/10 + 10;
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(arr, 0, newArray, 0, length);

        return newArray;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt();
        }
        System.out.println(new ObjectAnalyzer().toString(ints));

        System.out.println(new ObjectAnalyzer().toString(growArray(ints)));
    }
}
