package oop.design.patterns.dzone.mediator;

public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator m) {
        super(m);
    }

    public void receive(String message) {
        System.out.println("Colleague Received: " + message);
    }
}
