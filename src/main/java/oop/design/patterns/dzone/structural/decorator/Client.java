package oop.design.patterns.dzone.structural.decorator;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Enriches the functionality of existing methods at runtime when subclassing is impossible or not desirable.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Extends functionality of an object dynamically using composition instead of inheritance.<br />
 * 2. Because of 1. inheritance explosion is avoided.
 * 3. Each instance of the class can be enriched (decorated) differently.
 * 4. Its build on the design principle “Classes should be open for extension, but closed for modification.”
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * 1. Leads to systems with lots of small objects that look the same which makes it difficult to trace and debug.<br />
 * 2. Decorator and its wrappee are not the same so RTTI may fail.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Adding footer to outgoing mail, JDK readers and writers.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        Email email = new Email("Hello Betty");
        EmailSender sender = new EmailSender();
        sender.sendEmail(email);
    }
}
