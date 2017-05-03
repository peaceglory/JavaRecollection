package oop.design.dzone.chainofresponsibility;

/**
 * <p>
 * <b>Intent:</b><br />
 * Reduces coupling of client with request handler by creating a chain of responsible objects which can try to handle
 * the request one by one.
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>Client code is unaware of which object exactly will handle its request</li>
 * <li>Adding and removing request handlers form the chain diesn't affect the client and can happen at runtime</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>As with Observer it's difficult to trace the logic just by looking at it. Debugging is needed.</li>
 * <li>The request might end up unprocessed which needs to be taken care of.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Upload file handler, Email handler, Boot order.
 * </p>
 */
public class EmailClient {
    private EmailProcessor processor;

    public EmailClient() {
        createProcessor();
    }

    private void createProcessor() {
        processor = new EmailProcessor();
        processor.addHandler(new BusinessMailHandler());
        processor.addHandler(new GMailHandler());
    }

    public void addRule(EmailHandler handler) {
        processor.addHandler(handler);
    }

    public void emailReceived(Email email) {
        processor.handleRequest(email);
    }

    public static void main(String[] args) {
        EmailClient client = new EmailClient();
    }
}
