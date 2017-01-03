package sources.oop.design.dzone.bridge;

//Abstraction
public abstract class RemoteControl {
    private TV implementor;

    public void on() {
        implementor.on();
    }

    public void off() {
        implementor.off();
    }

    public void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }
}
