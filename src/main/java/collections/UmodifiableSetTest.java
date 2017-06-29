package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by developer on 6/29/17.
 */
public class UmodifiableSetTest {

    public static void main(String[] args) {
        Set<String> modifiable = new HashSet<>();
        modifiable.add("haha");

        Set<String> unmodifiable = Collections.unmodifiableSet(modifiable);
//        unmodifiable.add("Oh no");

        Set<String> isThisModifiable = new HashSet<>(unmodifiable);
        isThisModifiable.add("Let's see");

        isThisModifiable.forEach(System.out::println);
    }
}
