package sources.oop.design.mine.bridge;

import java.util.*;

/**
 * Created by mman on 02.01.17.
 *
 * When the problem we solve have two distinct aspects that potentially can evolve in different hierarchies,
 * separation by bridge is appropriate.
 *
 * In this case we solve the problem of printing messages. It has two aspects:
 * 1) Where do we print out the message.
 * 2) In what order do we print out the messages.
 *
 * Thus we separate the two aspects in different hierarchies - Printer and Collection, and bridge them together.
 */
public class Client {
    private static final String[] messages = {
            "However", "Indeed", "Lookout", "Welcome", "Absolutely!"
    };

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(messages.length);

        Queue<String> queue = new PriorityQueue<>(messages.length, (s1, s2) -> s1.compareTo(s2));

        for (String m : messages) {
            list.add(m);
            queue.add(m);
        }

        Printer printer = new ConsolePrinter(list);
        printer.print();

        printer = new ConsolePrinter(queue);
        printer.print();

        printer = new FilePrinter(list);
        printer.print();

        printer = new FilePrinter(queue);
        printer.print();
    }
}
