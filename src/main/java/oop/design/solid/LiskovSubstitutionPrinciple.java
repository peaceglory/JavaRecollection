package oop.design.solid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://stackify.com/solid-design-liskov-substitution-principle/
 *
 * https://www.youtube.com/watch?v=5RwhyZnVRS8&list=PLLWMQd6PeGY3ob0Ga6vn1czFZfW6e-FLr
 *
 * The subclass must be able to do what the super class is able to do.
 * This is why validation of input parameters of an overriden method in the subclass should NOT be stricter than the one
 * in the superclass.
 *
 * Example: if a basic coffee machine can brew filter coffee then a premmium machine should also be able to brew filter coffee.
 * Although it might also be able to brew espresso as well.
 */
public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {
        Person someone = new Person();
        someone.getHobbies(0);

        someone = new Person();
        final Collection<String> hobbies = someone.getHobbies(3);
    }
}

class Person {
    protected Collection<String> getHobbies(int upto) {
        if (upto < 0) {
            throw new IllegalArgumentException();
        }
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Meditation");
        hobbies.add("Painting");
        hobbies.add("Playing the drums");

        return hobbies;
    }
}

class User extends Person {
    @Override
    public LinkedList<String> getHobbies(int upto) {
        if (upto < 1) { // Violation of LSP: stricter validation in subclass
            throw new IllegalArgumentException();
        }
        LinkedList<String> hobbies = new LinkedList<>();
        hobbies.add("Meditation");
        hobbies.add("Painting");
        hobbies.add("Playing the drums");

        hobbies = hobbies.stream()
                .filter(h -> !h.equalsIgnoreCase("Meditation"))
                .collect(Collectors.toCollection(LinkedList::new));

        return hobbies;
    }
}
