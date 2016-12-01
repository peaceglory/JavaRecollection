package sources.oop.animals;

import java.lang.reflect.Method;

/**
 * Created by mman on 07.11.16.
 */
public class Dog extends DomesticAnimal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("Dog.walking");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Dog)) {
            return false;
        }
        Dog d = (Dog) obj;
        return this.getName().equals(d.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public Dog getChildren() {
        return null;
    }

    public static void main(String[] args) {
        for (Method m : Dog.class.getMethods()) {
            if (m.getName().equals("getChildren")) {
                System.out.println(m.toGenericString());
            }
        }
    }
}
