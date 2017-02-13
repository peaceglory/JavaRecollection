package sources.algorithms.misc;

/**
 * 0 1 1 2 3 5 8 13 21 34 55...
 */
public class Fibonachi {

    public static long fibonachi(int n) {
        if (n < 1) {
            return -1l;
        }
        if (n == 1) {
            return 0l;
        }
        if (n == 2) {
            return 1l;
        }
        return fibonachi(n - 1) + fibonachi(n - 2);
    }

    public static long fibonachiImproved(int n) {
        long[] cache = new long[n + 1];
        return fibonachi(n, cache);
    }

    private static long fibonachi(int n, long[] cache) {
        if (n < 1) {
            return -1l;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = fibonachi(n - 1, cache) + fibonachi(n - 2, cache);
        return cache[n];
    }

    public static long fibonachiLoop(int n) {
        if (n < 1) {
            return -1l;
        }
        long fib1 = 0, fib2 = 1, result = 0;

        if (n == 1) {
            result = fib1;
        } else if (n == 2) {
            result = fib2;
        } else {
            for (int i = 3; i <= n; i++) {
                result = fib1 + fib2;
                fib1 = fib2;
                fib2 = result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.printf("Fib %d: %d%n", n, fibonachiImproved(n));
    }
}
