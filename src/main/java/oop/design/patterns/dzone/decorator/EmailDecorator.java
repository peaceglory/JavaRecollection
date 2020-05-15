package oop.design.patterns.dzone.decorator;

public abstract class EmailDecorator implements IEmail {
    //wrapped component

    IEmail originalEmail;
}
