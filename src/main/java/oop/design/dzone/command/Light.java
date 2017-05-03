package oop.design.dzone.command;

//Receiver
public class Light {
    private boolean on;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }
}