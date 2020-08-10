package oop.design.patterns.dzone.structural.flyweight;

import java.awt.*;

//Flyweight
public interface LineFlyweight {
    public Color getColor();

    public void draw(Point location);
}
