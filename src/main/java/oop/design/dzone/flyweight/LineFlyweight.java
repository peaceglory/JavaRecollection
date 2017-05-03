package oop.design.dzone.flyweight;

import java.awt.*;

//Flyweight
public interface LineFlyweight {
    public Color getColor();

    public void draw(Point location);
}
