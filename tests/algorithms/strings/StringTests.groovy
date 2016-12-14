package tests.algorithms.strings

import sources.algorithms.strings.StringUtils
import sources.utils.StopWatch
import sources.utils.Utils

/**
 * Created by mman on 14.12.16.
 */
class StringTests extends GroovyTestCase {
    private static final int SIZE = 16000000;

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
}
