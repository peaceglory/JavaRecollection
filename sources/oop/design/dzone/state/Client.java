package sources.oop.design.dzone.state;

/**
 * <p>
 * <b>Intent:</b><br />
 * Distribute state dependent behaviour of an object across classes which represent different states of the object.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Less if/else statements thus greater readability and scalability.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Some operations are not relevant to specific states.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * MP3 Player, Elevator, Vending machine.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        MP3PlayerContext player = new MP3PlayerContext(new StandbyState());
        player.play();
        System.out.println(player.getState().name());

        player.play();
        System.out.println(player.getState().name());
    }
}
