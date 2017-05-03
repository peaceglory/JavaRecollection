package oop.design.dzone.command;

/**
 * <p>
 * <b>Intent:</b><br />
 * Encapsulates a client's request into an object allowing it to be handled when the time is appropriate.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Allows for callback functionality.<br />
 * 2. Allows for history of requests. <br />
 * 3. Decouples task invoker from the concrete object that knows what to do.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Every command needs a separate class.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Job queue, Remote control.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light();
        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);

        //switch on
        control.setCommand(lightsOn);
        control.pressButton();

        //switch off
        control.setCommand(lightsOff);
        control.pressButton();
    }
}
