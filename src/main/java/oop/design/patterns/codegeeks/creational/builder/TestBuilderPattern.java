package oop.design.patterns.codegeeks.creational.builder;

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
public class TestBuilderPattern {

	public static void main(String[] args) {
		CarBuilder carBuilder = new SedanCarBuilder();
		CarDirector director = new CarDirector(carBuilder);
		director.build();
		Car car = carBuilder.getCar();
		System.out.println(car);
		
		carBuilder = new SportsCarBuilder();
		director = new CarDirector(carBuilder);
		director.build();
		car = carBuilder.getCar();
		System.out.println(car);
	}

}
