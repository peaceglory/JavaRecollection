package algorithms.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algorithms.misc.SimilarityFinder;

/**
 * Created by mman on 20.03.17.
 */
class SimilarityFinderTest {

    @Test
    void testFindSimilar() {
        String[] initSentences = getInitSentences(false);

        SimilarityFinder sf = new SimilarityFinder(initSentences);
        String[] similar = sf.findSimilar("A time like this is not that sunny visit with a picnic basket.");

        Assertions.assertEquals(similar.length, 2);
    }

    private String[] getInitSentences(boolean bigText) {
        String[] initSentences = null;
        if (bigText) {
            // TODO
        } else {
            initSentences = new String[] {
                    "Once upon a time there was a princess.",
                    "Her name was the Red Riding hood.",
                    "Actually she was not exactly a princess but as a kid she used to dream about it.",
                    "So this was a sunny, sunny day and the little girl had to visit her grandma.",
                    "A story is a story, so she took the basket that was carefully prepared by her mom and set away.",
                    "So she was walking and walking and walking in the woods when suddenly a wolf appeared from the bushes.",
                    "To be continued you dummies!..."
            };
        }
        return initSentences;
    }
}
