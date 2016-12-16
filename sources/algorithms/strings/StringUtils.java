package sources.algorithms.strings;

import org.testng.log4testng.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by mman on 14.12.16.
 */
public class StringUtils {
    private static Set<String> forbiddenWords = null;

    static {
        Path path = Paths.get("/media/mman/Data/Big Files/1-1000.txt");
        try {
            List<String> wordList = Files.readAllLines(path);
            forbiddenWords = new HashSet<>(wordList);
        } catch (IOException e) {
            Logger.getLogger(StringUtils.class).error("Can't read file: " + path.getFileName() + "\n" + e.getMessage());
        }
    }

    /**
     *  Contains(source, pattern)
     *      s <- source.length
     *      p <- pattern.length
     *      For currS <- 0 to (s - p]
     *          currP <- 0
     *          While currP < p AND source[currS + currP] = pattern[currP]
     *              currP <- currP + 1
     *          If currP = p
     *              return currS
     *          currS <- currS + 1
     *      return (-1)
     */
    public static int contains(String source, String pattern) {
        int s = source.length();
        int p = pattern.length();

        for (int i = 0; i <= s - p; i++) {
            int j = 0;
            while (j < p && source.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == p) {
                return i;
            }
        }
        return -1;
    }

    /**
     *  ReverseWords(source)
     *      start <- source.length - 1
     *      end <- start
     *
     *      While end >= 0
     *          While start >= 0 AND source[start] != SPACE_CHAR
     *              start <- start - 1
     *          For i <- start + 1 to (end]
     *              sb.append(source[i])
     *          start <- start - 1
     *          end <- start
     *          If end >= 0
     *              sb.append(SPACE_CHAR)
     *
     *      return sb.toString()
     */
    public static String reverseWords(String source) {
        int length = source.length();
        int start = length - 1;
        int end = start;
        StringBuilder sb = new StringBuilder(length);
        while (end >= 0) {
            while (start >= 0 && !Character.isSpaceChar(source.charAt(start))) {
                start--;
            }
            for (int i = start + 1; i <= end; i++) {
                sb.append(source.charAt(i));
            }
            start--;
            end = start;
            if (end >= 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static boolean isPalindrome(String source) {
        int start = 0;
        int end = source.length() - 1;

        while (start < end) {
            while (!Character.isLetterOrDigit(source.charAt(start))) {
                start++;
            }
            while (!Character.isLetterOrDigit(source.charAt(end))) {
                end--;
            }
            if (Character.toUpperCase(source.charAt(start)) != Character.toUpperCase(source.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int countWords(String source) {
        if (source.isEmpty()) {
            return 0;
        }
        // Trim white spaces on both end if any.
        int index = 0;
        while (index < source.length() && Character.isWhitespace(source.charAt(index++)));
        int curr = index - 1;

        index = source.length() - 1;
        while (index >= 0 && Character.isWhitespace(source.charAt(index--)));
        int end = index + 1;

        int wordCount = 0;
        boolean inWord = false;
        while (curr <= end) {
            if (Character.isWhitespace(source.charAt(curr))) {
                inWord = false;
                wordCount++;
                while (curr <= end && !Character.isLetterOrDigit(source.charAt(curr++)));
            } else {
                inWord = true;
                curr++;
            }
        }
        return inWord ? ++wordCount : wordCount;
    }

    public static String mostFrequentWord(String source) {
        int index = 0;
        // Position index after any possible whitespaces.
        while (index < source.length() && Character.isWhitespace(source.charAt(index))) {
            index++;
        }
        // Check if whole string is a whitespace.
        if (index == source.length()) {
            return "";
        }

        Map<String, Integer> wordsByNumber = new HashMap<>();
        while (index < source.length()) {
            int start = index;
            // Progress to end of word.
            while (index < source.length() && Character.isLetterOrDigit(source.charAt(index))) {
                index++;
            }
            char[] word = new char[index - start];
            for (int i = 0; start < index; i++, start++) {
                word[i] = source.charAt(start);
            }

            String str = new String(word);
            str = str.toLowerCase();
            if (allowed(str)) {
                Integer val = wordsByNumber.get(str);
                val = (val == null ? 1 : ++val);
                wordsByNumber.put(str, val);
            }
            // Progress to beginning of next word if any.
            while (index < source.length() && !Character.isLetterOrDigit(source.charAt(index))) {
                index++;
            }
        }

        // Determine the winner
        int max = 1;
        String winner = "";

        for (Map.Entry<String, Integer> e : wordsByNumber.entrySet()) {
            int val = e.getValue();
            if (val > max) {
                max = val;
                winner = e.getKey();
            }
        }

        return winner;
    }

    public static int firstMatch(String source, String pattern) {
        int i = 0;
        do {
            while (i < source.length() && !Character.isLetterOrDigit(source.charAt(i))) {
                i++;
            }
            for (int j = 0; j < pattern.length() - 1; j++) {
                if (source.charAt(i) == pattern.charAt(j)) {
                    return i;
                }
            }
        } while (++i < source.length());

        return (-1);
    }

    private static boolean allowed(String word) {
        return !forbiddenWords.contains(word);
    }

    public static void main(String[] args) {
        String source = "    Ba baa black  sheep ,     have you any BlAck wool ?    ";
        String target = " black sheep, ";
        boolean found = contains(source, target) < 0 ? false : true;
        System.out.println(String.format("%s --> %s: %b", source, target, found));
        System.out.println(String.format("Words:%d", StringUtils.countWords(source)));
        System.out.println(String.format("The most frequent: %s", StringUtils.mostFrequentWord(source)));
        System.out.println(String.format("First match on: %d", StringUtils.firstMatch(source, "wrig")));
    }
}
