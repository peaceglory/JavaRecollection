package sources.oop.animals;

/**
 * Created by mman on 07.11.16.
 */
public class DomesticAnimal extends LandAnimal {
    private String name = null;

    public DomesticAnimal(String name) {
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println("DomesticAnimal.walking");
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof DomesticAnimal)) { // Danger: if obj is Dog this check passes.
            return false;
        }
        DomesticAnimal d = (DomesticAnimal) obj;
        return this.getName().equals(d.getName());
    }
}
