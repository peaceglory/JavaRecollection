package oop.design.patterns.codegeeks.behavioral.mediator;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Centralizes responsibility for how related objects interact with each other.
 * <p/>
 *
 * <p>
 * <b>Ups:</b><br />
 * Promotes loose coupling between the colleague classes.
 * <p/>
 *
 * <p>
 * <b>Downs:</b><br />
 * Complexity may still be there if no proper design is made up.
 * <p/>
 *
 * <p>
 * <b>Examples:</b><br />
 * Washing machine and its components, Chat room and its users, Control tower and airplanes
 * <p/>
 */
public class TestMediator {

	public static void main(String[] args) {
		MachineMediator mediator = null;
		Sensor sensor = new Sensor();
		SoilRemoval soilRemoval = new SoilRemoval();
		Motor motor = new Motor();
		Machine machine = new Machine();
		Heater heater = new Heater();
		Valve valve = new Valve();
		Button button = new Button();
		
		mediator = new CottonMediator(machine, heater, motor, sensor, soilRemoval, valve);
		
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		
		button.press();
		
		System.out.println("******************************************************************************");
		
		mediator = new DenimMediator(machine, heater, motor, sensor, soilRemoval, valve);
		
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		
		button.press();
	}

}
