package oop.design.patterns.dzone.behavioral.visitor;

//Element interface
public interface Visitable {

    public void accept(Visitor visitor);
}
