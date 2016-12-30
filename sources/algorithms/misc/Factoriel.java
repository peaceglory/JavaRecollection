package sources.algorithms.misc;

/**
 * Created by mman on 30.12.16.
 */
public class Factoriel {

    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static long factorialIter(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        long result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.printf("Fact(%d) = %d%n", n, factorialIter(n));
    }
}
