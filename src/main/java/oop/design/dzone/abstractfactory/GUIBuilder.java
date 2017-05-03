package oop.design.dzone.abstractfactory;

//Client
public class GUIBuilder {

    public void buildWindow(AbstractWidgetFactory widgetFactory) {
        Window window = widgetFactory.createWindow();
        window.setTitle("New Window");
    }
}
