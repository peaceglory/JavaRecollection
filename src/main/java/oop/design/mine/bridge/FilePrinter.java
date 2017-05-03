package oop.design.mine.bridge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

/**
 * Created by mman on 02.01.17.
 */
public class FilePrinter implements Printer {
    private Collection<String> messages = null;
    private final Path out = Paths.get("conf/oop/design/mine/bridge", "printOut.txt");

    public FilePrinter(Collection<String> messages) {
        this.messages = messages;
    }

    @Override
    public void print() {
        try {
            Files.write(out, messages, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
