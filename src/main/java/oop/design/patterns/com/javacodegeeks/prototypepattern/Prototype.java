package oop.design.patterns.com.javacodegeeks.prototypepattern;

public interface Prototype extends Cloneable {
	
	public AccessControl clone() throws CloneNotSupportedException;

}
