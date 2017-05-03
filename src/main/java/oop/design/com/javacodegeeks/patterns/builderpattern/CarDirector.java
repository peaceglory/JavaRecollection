package oop.design.com.javacodegeeks.patterns.builderpattern;


public class CarDirector {

    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    // The algorithm of creating a car object here seems to not matter. Just build different parts.
    // But if it mattered, a different director could be used.
    public void build() {
        carBuilder.buildBodyStyle();
        carBuilder.buildPower();
        carBuilder.buildEngine();
        carBuilder.buildBreaks();
        carBuilder.buildSeats();
        carBuilder.buildWindows();
        carBuilder.buildFuelType();
    }
}
