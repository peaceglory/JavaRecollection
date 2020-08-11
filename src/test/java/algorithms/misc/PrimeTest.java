package algorithms.misc;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Created by mman on 30.12.16.
 */
class PrimeTest {

    @Test
    void testIsPrime() {
        int[] primes = { 3, 5, 7, 11, 13, 17, 197, 199, 179 };
        int[] notPrimes = { 4, 6, 9, 15, 21 };

        for (int i = 0; i < primes.length; i++) {
            assertTrue(Prime.isPrime(primes[i]), "Not prime: " + primes[i]);
        }

        for (int i = 0; i < notPrimes.length; i++) {
            assertFalse(Prime.isPrime(notPrimes[i]), "Prime: " + notPrimes[i]);
        }
    }

    public void testListPrimesUntil() {
        int primesNeeded = 10;
        Prime.listPrimerSequence(primesNeeded);
    }
}
