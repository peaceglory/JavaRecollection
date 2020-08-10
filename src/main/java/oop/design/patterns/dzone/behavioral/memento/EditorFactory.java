package oop.design.patterns.dzone.behavioral.memento;

/**
 * Created by mman on 13.01.17.
 */
public class EditorFactory {

    private EditorFactory() throws IllegalAccessException {
        throw new IllegalAccessException("Can't instantiate this factory");
    }

    public static Editor newEditor() {
        return new Editor(new CareTaker());
    }
}
