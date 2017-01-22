package sources.oop.design.dzone.flyweight;

import java.awt.*;

//ConcreteFlyweight
public class Line implements LineFlyweight {
    private Color color;

    public Line(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Point location) {
        //draw the character on screen
    }
}
