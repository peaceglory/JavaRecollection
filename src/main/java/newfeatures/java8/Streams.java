package newfeatures.java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mman on 08.12.16.
 */
public class Streams {

    public void tapMethod() {
        
    }

    public static void main(String[] args) throws IOException {
        filterLongWords();

        filerLongWordsUsingArray();
    }

    public static void filterLongWords() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("/media/mman/Data/Big Files/big.txt")),
                                    StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("[\\P{L}]+"));
        long count = words.stream().filter((w) -> w.length() > 16).count();
        System.out.println("Long words:" + count);
    }

    public static void filerLongWordsUsingArray() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("/media/mman/Data/Big Files/big.txt")),
                                    StandardCharsets.UTF_8);
        String[] arr = content.split("[\\P{L}]+");
//        Stream<String> words = Stream.of(arr);
        Stream<String> words = Arrays.stream(arr, 0, 100);
        long count = words.filter((w) -> w.length() > 16).count();
        System.out.println("Long words:" + count);
    }
}
