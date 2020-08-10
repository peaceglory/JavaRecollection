package oop.design.patterns.dzone.creational.builder;

// Director
public class MealDirector {

    public Meal createMeal(MealBuilder builder) {
        builder.buildDrink();
        builder.buildMain();
        builder.buildDessert();
        return builder.getMeal();
    }
}
