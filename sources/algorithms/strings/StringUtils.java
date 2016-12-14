package sources.algorithms.strings;

/**
 * Created by mman on 14.12.16.
 */
public class StringUtils {

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

    public static void main(String[] args) {
        String source = "Ba baa black sheep, have you any wool?";
        String target = " black sheep, ";
        boolean found = contains(source, target) < 0 ? false : true;
        System.out.println(String.format("%s --> %s: %b", source, target, found));
    }
}
