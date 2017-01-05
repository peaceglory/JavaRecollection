package sources.oop.design.dzone.chainofresponsibility;

public class EmailProcessor {
    //maintain a reference to the previous handler so we can add the next one
    private EmailHandler handler;

    public void addHandler(EmailHandler handler) {
        if (this.handler != null) {
            this.handler.setNext(handler);
        }
        this.handler = handler;
    }

    public void handleRequest(Email email) {
        if (handler != null) {
            handler.handleRequest(email);
        }
    }
}

