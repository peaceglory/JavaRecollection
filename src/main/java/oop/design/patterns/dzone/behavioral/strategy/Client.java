package oop.design.patterns.dzone.behavioral.strategy;

import java.util.ArrayList;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 * <p>
 * <b>Intent:</b><br />
 * Encapsulate alternative approaches to a problem into separate classes each of which implement the same operation (interface).
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Less if/else statements thus greater readability and scalability.<br />
 * 2. Different strategies can be supplied by the client at runtime.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Sorting algorithms, File compression algorithms.
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        CompressionContext ctx = new CompressionContext();

        //we could assume context is already set by preferences
        ctx.setCompressionStrategy(new ZipCompressionStrategy());

        //get a list of files...
        ctx.createArchive(new ArrayList<>());
    }
}
