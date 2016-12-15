package sources.algorithms.strings;

/**
 * Created by mman on 14.12.16.
 */
public class StringUtils {

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

    public static void main(String[] args) {
        String source = "Ba baa black sheep, have you any wool?";
        String target = " black sheep, ";
        boolean found = contains(source, target) < 0 ? false : true;
        System.out.println(String.format("%s --> %s: %b", source, target, found));
    }
}
