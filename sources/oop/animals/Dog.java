package sources.oop.animals;

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
}
