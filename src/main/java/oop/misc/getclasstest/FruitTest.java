package oop.misc.getclasstest;

/**
 * Created by developer on 6/27/17.
 */
public class FruitTest {

    public static void main(String[] args) {
        Fruit f = new Fruit("Red", 2.5);
        Fruit a = new Apple("Red", 2.5, "Golden");
        Apple a2 = new Apple("Red", 2.5, "Golden");

        System.out.println(a.equals(f));
        System.out.println(a.equals(a2));
    }
}
