package collections;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mman on 03.02.17.
 */
public class SomeBasicTest {

    public static void main(String[] args) {
        Person[] p = { new Person("Niki"), new Person("Genka"), new Person("Kutzi") };
        List<Person> l = Arrays.asList(p);

//        Person per = l.get(1); // Change the list
        Person per = p[1]; // Change the array
        per.setName("Tzanka");

        // The list and the array show the changes.
        for (Person person : p) {
            System.out.println(person);
        }

        System.out.println();

        l.forEach(System.out::println);

        System.out.println();

        Person[] newP = l.toArray(p);
        newP[0].setName("Gogo");

        for (Person person : newP) {
            System.out.println(person);
        }

        System.out.println();

        for (Person person : p) {
            System.out.println(person);
        }

        System.out.println();

        l.forEach(System.out::println);
    }


}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
