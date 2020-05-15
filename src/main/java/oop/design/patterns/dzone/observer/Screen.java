package oop.design.patterns.dzone.observer;

import java.util.Observable;
import java.util.Observer;

public class Screen implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        //act on the update
    }
}
