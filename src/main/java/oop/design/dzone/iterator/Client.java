package oop.design.dzone.iterator;

/**
 * <p>
 * <b>Intent:</b><br />
 * Allows sequential access to the elements of an aggregate object without providing access to the underlying data structure.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Clients don't need to worry about the data structure when accessing the elements of the collection.<br />
 * 2. The aggregate interface is free from iteration related operations.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Needs a way to deal with concurrent access and access while iterating.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * JDK Collections.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        TV tv = new ConcreteTV();
        ChannelIterator iter = tv.getIterator();
        while (iter.hasNext()) {
            iter.currentItem();
            iter.next();
        }
    }
}
