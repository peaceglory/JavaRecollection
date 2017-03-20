package sources.algorithms.misc;

import java.util.*;


/**
 * Given some sentences a user adds a new sentence.
 * The algorithm must find if the newly added sentence is similar to the initial sentences.
 * Two sentences are considered similar if they have 3 or more words in common.
 */
public class SimilarityFinder {
    private Map<String, Set<Integer>> wordsBySentences;
    private String[] initSentences;

    public SimilarityFinder(String[] initSentences) {
        init(initSentences);
        this.initSentences = initSentences;
    }

    /*
     * map <- new HashMap of String and Set
     * For each sentence in initSentences
     *     For each word in sentence
     *         set <- map.get(word)
     *         If set = Null
     *             set <- New Set of Integers
     *             map.put(word, set)
     *         set.add(sentenceNumber)
     */
    private void init(String[] initSentences) {
        wordsBySentences = new HashMap<>();
        for (int sentenceNumber = 0; sentenceNumber < initSentences.length; sentenceNumber++) {
            String[] sentence = initSentences[sentenceNumber].split(" ");
            for (String word : sentence) {
                word = word.toLowerCase();
                Set<Integer> occurenceSet = wordsBySentences.get(word);
                if (occurenceSet == null) {
                    occurenceSet = new HashSet<>();
                    wordsBySentences.put(word, occurenceSet);
                }
                occurenceSet.add(sentenceNumber);
            }
        }
    }

    /*
     *  map <- New Map of Integer and Integer
     *  For each word in newSentence
     *      set <- globalMap.get(word)
     *      If set /= Null
     *          For each sentenceNumber in set
     *              timesFound <- map.get(sentenceNumber)
     *              If timesFound = Null
     *                  map.put(sentenceNumber, 1)
     *              Else
     *                  map.put(sentenceNumber, timesFound + 1)
     *
     *  similar <- New Array of Strings
     *  For each entry in map
     *      If entry.getValue() >= 3
     *          similar.add(initSentences[entry.getKey()])
     *
     *  Return similar
     */
    public String[] findSimilar(String newSentence) {
        Map<Integer, Integer> occurencesBySentenceNumber = new HashMap<>();
        Set<String> uniqueWords = getUniqueWords(newSentence);
        for (String w : uniqueWords) {
            Set<Integer> occurenceSet = wordsBySentences.get(w);
            if (occurenceSet != null) {
                Integer timesFound = 0;
                for (Integer sentNum : occurenceSet) {
                    timesFound = occurencesBySentenceNumber.get(sentNum);
                    int occurence = (timesFound == null ? 1 : timesFound + 1);
                    occurencesBySentenceNumber.put(sentNum, occurence);
                }
            }
        }

        List<String> similar = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : occurencesBySentenceNumber.entrySet()) {
            if (e.getValue() >= 3) {
                similar.add(initSentences[e.getKey()]);
            }
        }

        return similar.toArray(new String[similar.size()]);
    }

    private Set<String> getUniqueWords(String newSentence) {
        String[] words = newSentence.split(" ");
        Set<String> uniqueWords = new HashSet<>();
        for (String w : words) {
            w = w.toLowerCase();
            uniqueWords.add(w);
        }
        return uniqueWords;
    }
}
