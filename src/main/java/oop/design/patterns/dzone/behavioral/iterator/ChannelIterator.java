package oop.design.patterns.dzone.behavioral.iterator;

//Iterator interface
public interface ChannelIterator {
    public boolean hasNext();

    public void next();

    public String currentItem();
}
