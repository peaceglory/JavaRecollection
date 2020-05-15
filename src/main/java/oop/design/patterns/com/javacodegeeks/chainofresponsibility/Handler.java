package oop.design.patterns.com.javacodegeeks.chainofresponsibility;

public interface Handler {
	
	public void setHandler(Handler handler);
	public void process(File file);
	public String getHandlerName();
}
