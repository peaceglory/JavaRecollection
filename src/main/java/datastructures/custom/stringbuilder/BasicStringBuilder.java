package datastructures.custom.stringbuilder;

/**
 * Created by mman on 11.02.17.
 */
public class BasicStringBuilder {
    private static final int DEFAULT_SIZE = 10;
    private char[] string;
    private int size;

    public BasicStringBuilder() {
        string = new char[DEFAULT_SIZE];
        size = 0;
    }

    public BasicStringBuilder(String initialString) {
        string = initialString.toCharArray();
        size = string.length;
    }

    public BasicStringBuilder append(char ch) {
        if (needsToGrow()) {
            grow();
        }
        string[size++] = ch;
        return this;
    }

    @Override
    public String toString() {
        return new String(string);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private boolean needsToGrow() {
        return size == string.length;
    }

    private void grow() {
        char[] newString = new char[2 * string.length];
        System.arraycopy(string, 0, newString, 0, string.length);
        string = newString;
    }
}
