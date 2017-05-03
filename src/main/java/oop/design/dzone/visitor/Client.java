package oop.design.dzone.visitor;

/**
 * <p>
 * <b>Intent:</b><br />
 * Adds new operations to the public interface of a hierarchy when subclassing is impossible or not desirable.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Each subclass implements the operation (carried out by a concrete visitor) in a different way.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * 1. The new structure adds level of complexity. <br />
 * 2. The class hierarchy needs to be designed for Visitor pattern in advance.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Postage visitor visiting each item in a shopping cart to determine postage costs.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.calculatePostage();
    }
}
