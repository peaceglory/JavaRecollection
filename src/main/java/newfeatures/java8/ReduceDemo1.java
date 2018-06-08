package newfeatures.java8;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ReduceDemo1 {

    public static void main(String[] args) {
        int[] array = {23,43,56,97,32};

        System.out.println("Simple sum: " + Arrays.stream(array).sum());

        Arrays.stream(array).reduce((left, right) -> left + right).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));

        int startValue = 100;
        int reduce = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(reduce);

    }
}
