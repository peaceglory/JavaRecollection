package oop.misc.getclasstest;

/**
 * Created by developer on 6/27/17.
 */
public class Fruit {
    private final String color;
    private final double weight;

    public Fruit(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
//        if (this.getClass() != o.getClass()) {
//            return false;
//        }
        if (! (o instanceof Fruit)) {
            return false;
        }
        Fruit that = (Fruit) o;
        return this.color.equals(that.color) && this.weight == that.weight;
    }
}
