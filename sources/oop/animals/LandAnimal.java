package sources.oop.animals;

/**
 * Created by mman on 07.11.16.
 */
public abstract class LandAnimal implements Animal {
    private boolean isAlive = true;

    public LandAnimal() {
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    public abstract void walk();
}
