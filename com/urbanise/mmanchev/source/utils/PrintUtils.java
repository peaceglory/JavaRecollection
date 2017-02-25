package com.urbanise.mmanchev.source.utils;

import java.io.File;

/**
 * Created by mman on 25.02.17.
 */
public class PrintUtils {
    public static final String NL = System.lineSeparator();
    public static final String FS = File.separator;

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
