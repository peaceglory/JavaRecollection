package tests.algorithms.strings

import sources.algorithms.strings.StringUtils
import sources.utils.StopWatch
import sources.utils.Utils

/**
 * Created by mman on 14.12.16.
 */
class StringTests extends GroovyTestCase {
    private static final int SIZE = 1000;

    void testContains() {
        String source = Utils.createRandomString(SIZE);
        println source;
        String target = "sharpshooter";

        StopWatch timer = new StopWatch();
        timer.start();
        int found = StringUtils.contains(source, target);
        timer.stop();
        println "--------------------------------------------------------"
        println "Found at: " + found + ". Took " + timer.getResult();
    }

    void testReverseWords() {
        String source = Utils.createRandomString(SIZE);
        source.replace('\n', ' ');
        println source;
        println "_____________________________________________"
        println StringUtils.reverseWords(source);
    }

    void testIsPalindrome() {
        String source = "A dog! A panic in a pagoda.";
        assertEquals(true, StringUtils.isPalindrome(source));

        source = "A dog A panic in a pagoda.";
        assertEquals(true, StringUtils.isPalindrome(source));

        source = "A dog!! A panic in a pagoda.";
        assertEquals(true, StringUtils.isPalindrome(source));

        source = "A dog A panic in a pagodaaaa.";
        assertEquals(false, StringUtils.isPalindrome(source));
    }

    void testCountWords() {
        String source = Utils.createRandomString(SIZE);
        println source;
        println "__________________________________________";
        println ("Words found: " + StringUtils.countWords(source));
    }

    void testMostFrequent() {
        String source = Utils.createRandomString(SIZE);
        println source;
        println "____________________________________________";
        println "Most frequent word: " + StringUtils.mostFrequentWord(source);
    }

    void testFirstMatch() {
        String source = Utils.createRandomString(SIZE);
        println source;
        println "____________________________________________";
        println "First match on: " + StringUtils.firstMatch(source, "WWW");
    }

    void testPermutations() {
        String input = "123456789";
        println input;
        println "-----------------------------------------------"
        StringUtils.permutations(input);
    }
}
