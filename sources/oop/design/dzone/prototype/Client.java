package sources.oop.design.dzone.prototype;

/**
 * <p>
 * <b>Intent:</b><br />
 * Enables one-time initialization of complex objects which clients then clone and use.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. One time initialization of complex or similar objects.<br />
 * 2. Clients don't need to know how to create the object, they just clone it.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Object cloning is involved which is potentially error prone.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * User access control objects.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        ItemRegistry registry = new ItemRegistry();
        Item myBook = registry.createBasicItem("Book");
        myBook.setTitle("Custom Title");       //etc
    }
}
