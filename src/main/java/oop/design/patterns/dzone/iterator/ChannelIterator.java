package oop.design.patterns.dzone.iterator;

//Iterator interface
public interface ChannelIterator {
    public boolean hasNext();

    public void next();

    public String currentItem();
}
