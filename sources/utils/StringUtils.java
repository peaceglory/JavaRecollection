package sources.utils;

import sources.reflection.ObjectAnalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mman on 04.03.17.
 */
public class StringUtils {

    public static String toString(Object o) {
        return new ObjectAnalyzer().toString(o);
    }

    public static String getBigString() {
        Path filepath = Paths.get("/media/mman/Data/Big Files/big.txt");
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(filepath);
        } catch (IOException e) {
            return "This is emergency string " + e.getMessage();
        }
        String content = new String(bytes, StandardCharsets.UTF_8);
        return content;
    }

    public static String createRandomString(int size) {
        String content = getBigString();
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        int length = content.length();
        String randomStr = content.substring(generator.nextInt(0, length / 2), generator.nextInt(length / 2, length));
        if (size < randomStr.length()) {
            randomStr = randomStr.substring(0, size);
        }
        return randomStr;
    }
}
