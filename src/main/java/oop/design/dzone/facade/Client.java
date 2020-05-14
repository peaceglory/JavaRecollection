package oop.design.dzone.facade;

import java.util.Date;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Provides client with interface which is easy to use and hides the complexity of a subsystem (a third party).
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>Defines a specific entry point to a complex system.</li>
 * <li>Hides unnecessary complexities.</li>
 * <li>When the subsystem changes the client code doesn't need to change.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * <ul>
 * <li>Harder customization and fine tuning. If this is needed it can happen only by touching the code in the subsystem.
 *     (which is possible since Facade doesn't necessarily encapsulate the subsystem.)</li>
 * <li>When subsystem changes it has to be remembered that the facades should change as well.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>Web services</li>
 * <li>Booking system</li>
 * <li>Starting and stopping a server</li>
 * </ul>
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        Date from = new Date();
        Date to = new Date();

        TravelFacade facade = new TravelFacade();
        facade.getFlightsAndHotels(from, to);
    }
}
