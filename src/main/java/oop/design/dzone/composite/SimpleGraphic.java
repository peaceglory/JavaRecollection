package oop.design.dzone.composite;

//Leaf
public class SimpleGraphic implements Graphic {

    public void paint() {
        //run the paint operation
    }

    /** Because we have no children, these operations will do nothing  **/
    public void add(Graphic g) {
        //unsupported operation
    }

    public void remove(Graphic g) {
        //unsupported operation
    }

    public Graphic get(int index) {
        //unsupported operation
        return null;
    }
}




