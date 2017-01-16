package sources.oop.design.dzone.iterator;

import java.util.List;

//Concrete Aggregator
public class ConcreteTV implements TV {
    private ChannelIterator iterator;
    private List<String> channels;

    public ConcreteTV() {
        iterator = new ChannelIteratorImpl(channels);
    }

    public ChannelIterator getIterator() {
        return iterator;
    }
}