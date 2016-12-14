package sources.algorithms.strings;

/**
 * Created by mman on 14.12.16.
 */
public class StringUtils {

    public static int contains(String source, String target) {
        for (int i = 0; i < source.length(); i++) {
            int j = 0;
            int k = i;
            while (j < target.length() && k < source.length()) {
                if (source.charAt(k) == target.charAt(j)) {
                    j++; k++;
                } else {
                    break;
                }
            }
            if (j == target.length()) {
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
