package sources.oop.design.dzone.memento;

import java.util.Stack;

/**
 * Created by mman on 13.01.17.
 */
public class CareTaker {
    private Stack<EditorMemento> snapshots = new Stack<>();

    public CareTaker() {
    }

    public void addSnapshot(EditorMemento snapshot) {
        if (snapshots.size() > 10) {
            snapshots.remove(1); // Remove the first after initial state.
        }
        snapshots.push(snapshot);
    }

    public EditorMemento revertSnapshot() {
        if (snapshots.size() > 1) {
            return snapshots.pop();
        }
        return snapshots.peek();
    }

    /* TEST */
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("One");
        s.push("Two");
        s.push("Three");
        s.forEach(System.out::println);

        s.remove(0);
        s.forEach(System.out::println);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
