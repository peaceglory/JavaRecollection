package oop.misc.getclasstest;

/**
 * Created by developer on 6/27/17.
 */
public class Apple extends Fruit {
    private final String kind;

    public Apple(String color, double weight, String kind) {
        super(color, weight);
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
//        if (this.getClass() != o.getClass()) {
//            return false;
//        }
        if (! (o instanceof Apple)) {
            return false;
        }
        Apple that = (Apple) o;
        return super.equals(o) && this.kind.equals(that.kind);
    }
}
