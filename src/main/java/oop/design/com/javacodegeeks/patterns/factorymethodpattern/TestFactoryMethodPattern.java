package oop.design.com.javacodegeeks.patterns.factorymethodpattern;

public class TestFactoryMethodPattern {

	public static void main(String[] args) {
		DisplayService service = new FeedbackXMLDisplayService();
		service.display();
		
		service = new ErrorXMLDisplayService();
		service.display();
		
		service = new OrderXMLDisplayService();
		service.display();
		
		service = new ResponseXMLDisplayService();
		service.display();

	}

}
