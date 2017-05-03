package algorithms.misc;

import org.testng.annotations.Test;
import algorithms.misc.Prime;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by mman on 30.12.16.
 */
public class PrimeTest {

    @Test
    public void testIsPrime() {
        int[] primes = { 3, 5, 7, 11, 13, 17, 197, 199, 179 };
        int[] notPrimes = { 4, 6, 9, 15, 21 };

        for (int i = 0; i < primes.length; i++) {
            assertTrue("Not prime: " + primes[i], Prime.isPrime(primes[i]));
        }

        for (int i = 0; i < notPrimes.length; i++) {
            assertFalse("Prime: " + notPrimes[i], Prime.isPrime(notPrimes[i]));
        }
    }

    public void testListPrimesUntil() {
        int primesNeeded = 10;
        Prime.listPrimerSequence(primesNeeded);
    }
}