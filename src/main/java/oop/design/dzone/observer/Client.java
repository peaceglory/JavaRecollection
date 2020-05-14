package oop.design.dzone.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Define a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically. Realizes publisher-subscriber model.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Allows notification of objects for interesting changes in another object.
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>
 *     Inversion of control between subject and observable is seamless.
 *     Detecting problems and debugging might be especially hard if observers are also subjects.
 *     So no chains of observers (observers observing other observers).
 * </li>
 * <li>Potential memory leaks if observers are not correctly detached.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * RSS feed, SMS notifications, Magazine subscription, UI data grids.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        Observer screen = new Screen();
        Observable dataStore = new DataStore();
        //register observer
        dataStore.addObserver(screen);

        //send a notification when data changes.
        dataStore.notifyObservers();
    }
}
