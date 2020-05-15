package oop.design.patterns.com.javacodegeeks.visitorpattern;

public interface Visitor {
	public void visit(HtmlElement element);
	public void visit(HtmlParentElement parentElement);
}
