package oop.design.dzone.mediator;

public class MobileColleague extends Colleague {

    public MobileColleague(Mediator m) {
        super(m);
    }

    public void receive(String message) {
        System.out.println("Mobile Received: " + message);
    }
}