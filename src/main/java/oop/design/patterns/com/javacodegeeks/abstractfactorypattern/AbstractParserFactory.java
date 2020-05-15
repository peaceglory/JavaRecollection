package oop.design.patterns.com.javacodegeeks.abstractfactorypattern;

public interface AbstractParserFactory {

	public XMLParser getParserInstance(String parserType);
}
