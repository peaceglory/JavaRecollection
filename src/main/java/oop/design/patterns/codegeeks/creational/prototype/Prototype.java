package oop.design.patterns.codegeeks.creational.prototype;

public interface Prototype extends Cloneable {
	
	public AccessControl clone() throws CloneNotSupportedException;

}
