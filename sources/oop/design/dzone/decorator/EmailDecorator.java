package sources.oop.design.dzone.decorator;

public abstract class EmailDecorator implements IEmail {
    //wrapped component

    IEmail originalEmail;
}
