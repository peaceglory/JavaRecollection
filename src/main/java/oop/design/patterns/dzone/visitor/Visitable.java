package oop.design.patterns.dzone.visitor;

//Element interface
public interface Visitable {

    public void accept(Visitor visitor);
}
