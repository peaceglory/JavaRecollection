package oop.design.patterns.codegeeks.creational.abstractfactory;

public interface AbstractParserFactory {

	public XMLParser getParserInstance(String parserType);
}
