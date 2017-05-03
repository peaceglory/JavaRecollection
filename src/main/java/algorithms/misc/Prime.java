package algorithms.misc;

/**
 * Created by mman on 30.12.16.
 */
public class Prime {

    public static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void listPrimerSequence(int sequenceLength) {
        int primesFound = 0, current = 0;
        while (primesFound < sequenceLength) {
            if (isPrime(current)) {
                System.out.println(current);
                primesFound++;
            }
            current++;
        }
    }
}
