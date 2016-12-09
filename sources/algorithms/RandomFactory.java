package sources.algorithms;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;
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
        throw new NotImplementedException();
    }
}
