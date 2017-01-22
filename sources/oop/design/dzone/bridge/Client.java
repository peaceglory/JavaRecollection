package sources.oop.design.dzone.bridge;

/**
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
public class Client {

    public static void main(String[] args) {
        TV sony = new Sony(); // Implementor - HOW is done
        RemoteControl remote = new ConcreteRemote(sony); // Abstraction - WHAT is done.
        remote.on();
        remote.off();
    }
}
