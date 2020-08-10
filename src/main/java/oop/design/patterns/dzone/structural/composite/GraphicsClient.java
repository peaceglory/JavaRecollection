package oop.design.patterns.dzone.structural.composite;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Realizes the part-whole relationship.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Provides client with the possibility to treat individual objects and groups of objects in the same way.
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>Adds a level of complexity since problems like ordering and cycles need to be taken care of.</li>
 * <li>The single responsibility of a class is lost.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>File system</li>
 * <li>XML and HTML parsers</li>
 * </ul>
 * </p>
 */
public class GraphicsClient {

    /**
     * Given a graphics context, client can just call paint, without worrying if this is a composite or leaf
     **/
    public void paint(Graphic g) {
        g.paint();
    }
}
