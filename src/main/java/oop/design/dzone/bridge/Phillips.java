package oop.design.dzone.bridge;

//Concrete Implementor
public class Phillips implements TV {

    public void on() {
        //Philips specific on
    }

    public void off() {
        //Philips specific off
    }

    public void tuneChannel(int channel) {
        //Philips specific tuneChannel
    }
}
