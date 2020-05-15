package oop.design.patterns.com.javacodegeeks.decoratorpattern;

public abstract class PizzaDecorator implements Pizza {
	
	@Override
	public String getDesc() {
		return "Toppings";
	}

}
