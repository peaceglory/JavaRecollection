package oop.design.patterns.codegeeks.structural.bridge;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Separates abstraction and implementation into different hierarchies.
 * When a problem has two aspects which can evolve in their own hierarchies bridge is appropriate.
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>Limits inheritance explosion</li>
 * <li>Useful when both WHAT a class does and HOW it does it varies very often</li>
 * <li>Abstraction and implementation (what and how) don't need to be bound at compile time</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>Adds complexity</li>
 * <li>Abstraction needs to send messages to implementor which is potential performance penalty</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>Console and file printer</li>
 * <li>TV set and remote control</li>
 * </ul>
 * </p>
 */
public class TestBridgePattern {

	public static void main(String[] args) {
		Product product = new CentralLocking("Central Locking System");
		Product product2 = new GearLocking("Gear Locking System");
		Car car = new BigWheel(product , "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println();
		
		car = new BigWheel(product2 , "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println("-----------------------------------------------------");
		
		car = new Motoren(product, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println();
		
		car = new Motoren(product2, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
	}

}
