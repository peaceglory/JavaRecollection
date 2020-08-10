package oop.design.patterns.dzone.structural.decorator;

//concrete decorator
public class SecureEmailDecorator extends EmailDecorator {
    private String content;

    public SecureEmailDecorator(IEmail basicEmail) {
        originalEmail = basicEmail;
    }

    @Override
    public String getContents() {
        //  secure original
        content = encrypt(originalEmail.getContents());
        return content;
    }

    private String encrypt(String message) {
        //encrypt the string
        String encryptedMessage = message + " ENCRYPTED";
        return encryptedMessage;
    }
}
