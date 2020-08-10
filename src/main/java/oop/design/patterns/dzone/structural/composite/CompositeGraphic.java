package oop.design.patterns.dzone.structural.composite;

import java.util.ArrayList;
import java.util.List;

//Composite
public class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<Graphic>();

    public void paint() {
        //run the paint operation for each child
        for (Graphic g : children) {
            g.paint();
        }
    }

    public void add(Graphic g) {
        children.add(g);
    }

    public void remove(Graphic g) {
        if (children.contains(g)) {
            children.remove(g);
        }
    }

    public Graphic get(int index) {
        if (index < children.size()) {
            return children.get(index);
        }
        return null;
    }
}
