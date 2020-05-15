package oop.design.patterns.dzone.visitor;

public interface Visitor {

    public void visit(Book book);

    public void visit(CD cd);

    public void visit(DVD dvd);
}