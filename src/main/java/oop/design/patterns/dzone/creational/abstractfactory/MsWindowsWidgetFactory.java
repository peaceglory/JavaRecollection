package oop.design.patterns.dzone.creational.abstractfactory;

//ConcreteFactory1
public class MsWindowsWidgetFactory implements AbstractWidgetFactory {

    //create an MSWindow
    public Window createWindow() {
        MSWindow window = new MSWindow();
        return window;
    }
}
