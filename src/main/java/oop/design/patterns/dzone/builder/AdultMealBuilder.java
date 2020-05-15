package oop.design.patterns.dzone.builder;

public class AdultMealBuilder extends MealBuilder {
    public void buildDrink(){
        // add drinks to the meal
    }
    public void buildMain(){
        // add main part of the meal
    }
    public void buildDessert(){
        // add dessert part to the meal
    }
    public Meal getMeal(){return meal;}
}
