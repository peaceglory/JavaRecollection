package sources.oop.design.dzone.memento;

/**
 * <p>
 * <b>Intent:</b><br />
 * Externalize and save the internal state of an object without breaking the encapsulation.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Object's state can be reverted for later use or for error recovery.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * 1. Might be time consuming.<br />
 * 2. Danger of breaking encapsulation.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Undo, Snapshots.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        Editor originator = EditorFactory.newEditor();
        System.out.println(originator.getEditorContents());

        originator.setState("ONE");
        originator.setState("TWO");
        originator.save();
        originator.setState("THREE");
        System.out.println(originator.getEditorContents());

        originator.undo();
        System.out.println(originator.getEditorContents());
    }
}
