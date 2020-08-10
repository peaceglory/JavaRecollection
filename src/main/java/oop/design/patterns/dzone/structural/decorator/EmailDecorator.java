package oop.design.patterns.dzone.structural.decorator;

public abstract class EmailDecorator implements IEmail {
    //wrapped component

    IEmail originalEmail;
}
