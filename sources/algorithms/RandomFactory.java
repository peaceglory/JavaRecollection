package sources.algorithms;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Created by mman on 09.12.16.
 */
public interface RandomFactory {

    static Integer[] createRandomIntegerArray(int size) {
        Stream<Integer> ints = Stream.generate(() -> new Random().nextInt(1000)).limit(size);
        return ints.toArray(Integer[]::new);
    }

    static String[] createRandomStringArray(int size) {
        Path filepath = Paths.get("/media/mman/Data/Big Files/big.txt");
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(filepath);
        } catch (IOException e) {
            return new String[]{"This", "is", "emergency", "array"};
        }
        String content = new String(bytes, StandardCharsets.UTF_8);
        String[] strArray = content.split("[\\P{L}]+");
        ThreadLocalRandom r = ThreadLocalRandom.current();
        strArray = Arrays.copyOfRange(strArray,
                                      r.nextInt(0, strArray.length/2),
                                      r.nextInt(strArray.length/2, strArray.length));
        if (size < strArray.length) {
            strArray = Arrays.copyOfRange(strArray, 0, size);
        }
        return strArray;
    }
}
