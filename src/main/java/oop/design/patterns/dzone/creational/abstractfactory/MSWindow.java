package oop.design.patterns.dzone.creational.abstractfactory;

//ConcreteProductA1
public class MSWindow implements Window {

    @Override
    public void setTitle(String text) {
        //MS Windows specific behaviour
    }

    public void repaint(){
        //MS Windows specific behaviour
    }
}
