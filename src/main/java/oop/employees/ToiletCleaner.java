package oop.employees;

/**
 * Created by mman on 03.12.16.
 */
public class ToiletCleaner extends Employee implements Cloneable {
    private ToiletCleaner shiftBuddy = null;

    public ToiletCleaner(String name, double salary) {
        super(name, salary);
    }

    @Override
    public ToiletCleaner clone() throws CloneNotSupportedException {
        // Shallow clone. Will not work well since shiftBuddy is mutable. Deep copy will be needed.
        return (ToiletCleaner) super.clone();
    }

    public void setShiftBuddy(ToiletCleaner shiftBuddy) {
        this.shiftBuddy = shiftBuddy;
    }

    public ToiletCleaner getShiftBuddy() {
        return this.shiftBuddy;
    }
}
