package sources.oop.design.dzone.abstractfactory;

//ConcreteProductA2
public class MacOSXWindow implements Window {

    @Override
    public void setTitle(String text) {
        //Mac OSX specific behaviour
    }

    public void repaint() {
        //Mac OSX specific behaviour
    }
}
