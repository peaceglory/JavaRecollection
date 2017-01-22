package sources.oop.design.dzone.flyweight;

import java.awt.*;

/**
 * <p>
 * <b>Intent:</b><br />
 * Makes for reusing objects by distributing responsibility between them and their clients.
 * The responsibility of the flyweight object is to keep reusable (intrinsic) state while the responsibility of client
 * is to pass non-reusable (extrinsic) state to the flyweight.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * There's no need to create a large number of expensive (storage, CPU, network, memory) objects by
 * providing simple caching.
 * </p>
 *
 * <p><b>Downs:</b><br />
 * All flyweight instances are related to each other (because of the shared state) so any state changes by one client
 * affect all other clients of the same flyweights. So either this should not matter or the flyweights should be made
 * immutable.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Drawing app, code platform.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        LineFlyweightFactory factory = new LineFlyweightFactory();
        LineFlyweight line = factory.getLine(Color.RED);
        LineFlyweight line2 = factory.getLine(Color.RED);

        //can use the lines independently
        line.draw(new Point(100, 100));
        line2.draw(new Point(200, 100));
    }
}
