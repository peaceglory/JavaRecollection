package oop.design.patterns.dzone.mediator;

//Mediator interface
public interface Mediator {

    public void send(String message, Colleague colleague);
}
