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
     *      For strIndex <- 0 to (s - p]
     *          pattIndex <- 0
     *          While pattIndex < p AND source[strIndex + pattIndex] = pattern[pattIndex]
     *              pattIndex <- pattIndex + 1
     *          If pattIndex = p
     *              return strIndex
     *          strIndex <- strIndex + 1
     *      return (-1)
     */
    public static int contains(String str, String pattern) {
        int s = str.length();
        int p = pattern.length();

        for (int strIndex = 0; strIndex <= s - p; strIndex++) {
            int pattIndex = 0;
            while (pattIndex < p && str.charAt(strIndex + pattIndex) == pattern.charAt(pattIndex)) {
                pattIndex++;
            }
            if (pattIndex == p) {
                return strIndex;
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
     *          For i <- start + 1 to end
     *              stringBuffer.append(source[i])
     *          start <- start - 1
     *          end <- start
     *          If end >= 0
     *              stringBuffer.append(SPACE_CHAR)
     *
     *      return stringBuffer.toString()
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

    // FIXME: This method blows up when str is an empty string with length>2. It needs checks in the inner whiles.
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            while (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            }
            while (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            }
            if (Character.toUpperCase(str.charAt(start)) != Character.toUpperCase(str.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int countWords(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        // Trim white spaces on both end if any.
        int index = 0;
        while (index < str.length() && Character.isWhitespace(str.charAt(index))) {
            index++;
        }
        int begin = index - 1;

        index = str.length() - 1;
        while (index >= 0 && Character.isWhitespace(str.charAt(index))) {
            index--;
        }
        int end = index + 1;

        int wordCount = 0;
        boolean inWord = false;
        while (begin <= end) {
            if (Character.isWhitespace(str.charAt(begin))) {
                inWord = false;
                wordCount++;
                while (begin <= end && !Character.isLetterOrDigit(str.charAt(begin))) {
                    begin++;
                }
            } else {
                inWord = true;
                begin++;
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

    // FIXME: What exactly is this supposed to do?
    public static int firstMatch(String source, String pattern) {
        int i = 0;
        do {
            while (i < source.length() && !Character.isLetterOrDigit(source.charAt(i))) {
                i++;
            }
            int j = 0;
            for ( ; i < source.length() && j < pattern.length(); i++, j++) {
                if (source.charAt(i) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pattern.length()) {
                return i;
            }
        } while (++i < source.length());

        return (-1);
    }

    public static void permutations(String str) {
        permutations(str, "");
    }

    private static void permutations(String str, String prefix) {
        if (str.isEmpty()) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            permutations(rem, prefix + str.charAt(i));
        }
    }

    public static boolean anagrams(String str1, String str2) {
        int[] arr = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            arr[Character.toLowerCase(str1.charAt(i)) - 'a']++;
        }

        for (int j = 0; j < str2.length(); j++) {
            arr[Character.toLowerCase(str2.charAt(j)) - 'a']--;
        }

        int k = 0;
        while (k < arr.length && arr[k] == 0) {
            k++;
        }

        return k == arr.length;
    }

    public static String reverseIterative(String str) {
        // With string builder
//        StringBuilder sb = new StringBuilder(str.length());
//        for (int i = str.length() - 1; i >= 0; i--) {
//            sb.append(str.charAt(i));
//        }
//        return sb.toString();

        // With tmp
        char[] chars = str.toCharArray();
        char tmp = ' ';
        for (int iStr = 0; iStr < (chars.length >> 1); iStr++) {
            tmp = chars[iStr];
            int otherEnd = chars.length - 1 - iStr;
            chars[iStr] = chars[otherEnd];
            chars[otherEnd] = tmp;
        }
        return new String(chars);
    }

    public static String reverseRecursive(String str) {
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }

    /**
     * The following code prints all strings of length k where the characters are in sorted order. It
     * does this by generating all strings of length k and then checking if each is sorted. What is its
     * runtime?
     */
    public static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    private  static void printSortedStrings(int remaining, String prefix) {
        int numChars = 26;

        if (remaining == 0) {
            if (islnOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars ; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    private static boolean islnOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    private static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
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
        System.out.println(String.format("First match on: %d", StringUtils.firstMatch(source, "black")));
        System.out.println("Reverse iterative:\n" + reverseIterative(source));
        System.out.println("Reverse recursive:\n" + reverseRecursive(source));

        printSortedStrings(2);
    }
}
