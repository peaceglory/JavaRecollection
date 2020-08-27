package oop.design.patterns.codegeeks.structural.decorator;

import java.text.DecimalFormat;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Enriches the functionality of existing methods at runtime when subclassing is impossible or not desirable.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Extends functionality of an object dynamically using composition instead of inheritance.<br />
 * 2. Because of 1. inheritance explosion is avoided.
 * 3. Each instance of the class can be enriched (decorated) differently.
 * 4. It complies with “Classes should be open for extension, but closed for modification.”
 * 5. It complies with Liskov Substitution Principle - decorator can be used anywhere where the core object is used without change
 *      (The decorator does everything that core object does + some more)
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * 1. Leads to systems with lots of small objects that look the same which makes it difficult to trace and debug.<br />
 * 2. Decorator and its wrappee are not the same so RTTI may fail.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Adding footer to outgoing mail, JDK readers and writers.
 * </p>
 */
public class TestDecoratorPattern {

    public static void main(String[] args) {
        DecimalFormat dformat = new DecimalFormat("#.##");
        Pizza pizza = new SimplyVegPizza(); // The interface and implementation might be provided by some library

        // these decorations might be provided by our app code because are needed but are not provided by the library
        // Thus we avoid inheritance explosion with classes for all permutations like PizzaWithRomaTomatoesAndGreenOlives
        pizza = new RomaTomatoes(pizza);
        pizza = new GreenOlives(pizza);
        pizza = new Spinach(pizza);

        // or just
        // pizza = new Spinach(new GreenOlives(new RomaTomatoes(new SimplyVegPizza())));

        System.out.println("Desc: " + pizza.getDesc());
        System.out.println("Price: " + dformat.format(pizza.getPrice()));

        pizza = new SimplyNonVegPizza();

        pizza = new Meat(pizza);
        pizza = new Cheese(pizza);
        pizza = new Cheese(pizza);
        pizza = new Ham(pizza);

        System.out.println("Desc: " + pizza.getDesc());
        System.out.println("Price: " + dformat.format(pizza.getPrice()));
    }

}
