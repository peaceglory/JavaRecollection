package com.urbanise.mmanchev.source.graph;

/**
 * This interface represents a graph data structure that is capable of building itself from provided data in a specific
 * format. After calling the <name>build()</name> method this graph has all its vertex dependencies at place.
 *
 * @author mmanchev, 25.02.17
 */
public interface DependencyGraph {

    /**
     * Builds the vertex dependencies.
     * @return string representing the vertex dependencies in a specific format.
     */
    public String build();

}
