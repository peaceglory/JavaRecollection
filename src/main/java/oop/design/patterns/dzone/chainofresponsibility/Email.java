package oop.design.patterns.dzone.chainofresponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mman on 05.01.17.
 */
public class Email {
    private String from;
    private List<String> to;
    private String text;

    public Email(String text, String from, String... to) {
        this.text = text;
        this.from = from;
        this.to = Arrays.asList(to);

    }

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public String getText() {
        return text;
    }
}
