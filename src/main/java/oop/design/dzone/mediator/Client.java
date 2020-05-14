package oop.design.dzone.mediator;


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
public class Client {

    public static void main(String[] args) {
        ApplicationMediator mediator = new ApplicationMediator();

        Colleague desktop = new ConcreteColleague(mediator);
        Colleague mobile = new MobileColleague(mediator);

        mediator.addColleague(desktop);
        mediator.addColleague(mobile);

        desktop.send("Hello World");
        mobile.send("Hello");
    }
}
