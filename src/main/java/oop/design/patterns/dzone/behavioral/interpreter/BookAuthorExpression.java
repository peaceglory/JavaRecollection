package oop.design.patterns.dzone.behavioral.interpreter;

import java.util.ArrayList;

//Concrete Expression
public class BookAuthorExpression extends AbstractExpression {
    private String searchString;

    public BookAuthorExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Book> books = context.getAllBooks();
        StringBuffer result = new StringBuffer();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(searchString)) {
                result.append(book.toString());
            }
        }
        return result.toString();
    }
}
