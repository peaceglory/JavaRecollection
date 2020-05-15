package oop.design.patterns.com.javacodegeeks.visitorpattern;

public interface Element {
	
	public void accept(Visitor visitor);
}
