package sources.oop.design.mine.bridge;

import java.util.Collection;

/**
 * Created by mman on 02.01.17.
 */
public class ConsolePrinter implements Printer {
    private Collection<String> messages = null;

    public ConsolePrinter(Collection<String> messages) {
        this.messages = messages;
    }

    @Override
    public void print() {
        messages.forEach(System.out::println);
    }
}
