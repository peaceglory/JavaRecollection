package sources.oop.design.dzone.bridge;

//Refined abstraction
public class ConcreteRemote extends RemoteControl {
    private int currentChannel;

    public ConcreteRemote(TV implementor) {
        super(implementor);
    }

    public void nextChannel() {
        currentChannel++;
        setChannel(currentChannel);
    }

    public void prevChannel() {
        currentChannel--;
        setChannel(currentChannel);
    }
}
