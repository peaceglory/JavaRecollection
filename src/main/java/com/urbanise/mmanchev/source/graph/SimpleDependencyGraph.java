package com.urbanise.mmanchev.source.graph;

import com.urbanise.mmanchev.source.helpers.MemoryQueue;
import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.*;

/**
 * A concrete dependency graph implementation.
 * This class uses adjacency map to represent vertex dependencies.
 *
 * @author mmanchev, 25.02.17
 */
public class SimpleDependencyGraph extends AbstractDependencyGraph {
    /**
     * Maps the name of a vertex to a list of adjacent vertexes.
     */
    private Map<String, List<String>> adjacencyMap = new HashMap<>();

    /**
     * Constructs a <name>SimpleDependencyGraph</name> object and handles the formatting of the input to the superclass.
     * @param input
     */
    public SimpleDependencyGraph(String input) {
        super(input);
    }

    @Override
    public String build() {
        String[] feedLine;
        List<String> adjList;

        for (String s : getInput()) {
            if (s.equals(PrintUtils.NL)) {
                continue;
            }
            feedLine = s.split(" ");
            adjList = new LinkedList<>();
            adjacencyMap.put(feedLine[0], adjList);

            for (int i = 1; i < feedLine.length; i++) {
                adjacencyMap.get(feedLine[0]).add(feedLine[i]);
            }
        }

        return asString();
    }

    /* Iterates the graph in Breadth-First-Search order and constructs a string representing the graph. */
    private String asString() {
        Iterator<String> adjMapKeySetIterator = adjacencyMap.keySet().iterator();
        MemoryQueue<String> queue = new MemoryQueue<>();
        StringBuilder sb = new StringBuilder();

        while (adjMapKeySetIterator.hasNext()) {
            String start = adjMapKeySetIterator.next();
            queue.offer(start);

            while (!queue.isEmpty()) {
                String s = queue.remove();
                sb.append(s);
                List<String> dependencies = adjacencyMap.get(s);
                if (dependencies != null) {
                    dependencies.forEach(queue::offer);
                }
                if (!queue.isEmpty()) {
                    sb.append(" ");
                }
            }

            queue.clearMemory();
            sb.append(PrintUtils.NL);
        }

        return sb.toString().trim();
    }
}
