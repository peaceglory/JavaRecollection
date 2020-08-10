package oop.design.patterns.dzone.behavioral.visitor;

public interface Visitor {

    public void visit(Book book);

    public void visit(CD cd);

    public void visit(DVD dvd);
}