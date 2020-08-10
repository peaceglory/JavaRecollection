package oop.design.patterns.dzone.creational.builder;

/**
 * <p>
 * <b>Type: Creational</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Moves the construction logic of an object outside the class that is to be instantiated.
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>Objects can be constructed part by part.</li>
 * <li>Objects can be constructed when the needed resources are present.</li>
 * <li>Different Directors (which are optional to the pattern) make it possible to define different algorithms of creating the object.</li>
 * <li>Provides good solution when otherwise big and bulky constructors would be used.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Possibly promotes the use of if/else statements.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Text parsers, Car production, Cake baking.
 * </p>
 */
public class Client {
    public static void main(String[] args) {
        boolean isKid = true;
        MealDirector director = new MealDirector();
        MealBuilder builder = null;
        if (isKid) {
            builder = new KidsMealBuilder();
        } else {
            builder = new AdultMealBuilder();
        }
        Meal meal = director.createMeal(builder);
    }
}
