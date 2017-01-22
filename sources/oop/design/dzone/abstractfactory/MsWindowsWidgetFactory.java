package sources.oop.design.dzone.abstractfactory;

//ConcreteFactory1
public class MsWindowsWidgetFactory implements AbstractWidgetFactory {

    //create an MSWindow
    public Window createWindow() {
        MSWindow window = new MSWindow();
        return window;
    }
}
