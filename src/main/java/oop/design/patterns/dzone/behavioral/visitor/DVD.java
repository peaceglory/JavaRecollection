package oop.design.patterns.dzone.behavioral.visitor;

/**
 * Created by mman on 16.01.17.
 */
public class DVD implements Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
