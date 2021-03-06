package oop.design.patterns.codegeeks.behavioral.templatemethod;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Defines the steps of an algorithm in an operation leaving to subclasses (clients) the specific implementation of some or all of the steps.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Sets and controls a framework in which clients can hook at their own points of interest.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Logic might be difficult to trace without debugger.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Algorithm for connecting to DB, Algorithm for sending messages (video, pic, text) in an instant messenger.
 * </p>
 */
public class TestTemplatePattern {

    public static void main(String[] args) {
        System.out.println("For MYSQL....");
        ConnectionTemplate template = new MySqLCSVCon();
        template.run();

        System.out.println("\nFor Oracle...");
        template = new OracleTxtCon();
        template.run();
    }

}
