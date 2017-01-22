package sources.oop.design.dzone.iterator;

//Concrete Iterator

import java.util.List;

public class ChannelIteratorImpl implements ChannelIterator {
    private List<String> channels;
    private int currentPos = 0;

    public ChannelIteratorImpl(List<String> channels) {
        this.channels = channels;
    }

    public boolean hasNext() {
        if (currentPos + 1 < channels.size()) {
            return true;
        }
        return false;
    }

    public void next() {
        currentPos++;
    }

    public String currentItem() {
        return channels.get(currentPos);
    }
}
