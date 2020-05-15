package oop.design.patterns.dzone.factorymethod;

//ConcreteCreator
public class XMLLoggerCreator extends AbstractLoggerCreator {

    @Override
    public Logger createLogger() {
        XMLLogger logger = new XMLLogger();
        return logger;
    }
}
