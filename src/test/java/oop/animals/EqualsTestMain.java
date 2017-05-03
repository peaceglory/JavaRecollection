package oop.animals;

import oop.animals.Dog;
import oop.animals.DomesticAnimal;

/**
 * Created by mman on 07.11.16.
 */
public class EqualsTestMain {

    public static void main(String[] args) {
        DomesticAnimal a1 = new DomesticAnimal("Charlie");
        DomesticAnimal a2 = new Dog("Charlie");

        System.out.println( "equal: " + a1.equals(a2)); // The contract should be met.
        System.out.println( "equal: " + a2.equals(a1));
    }
}
