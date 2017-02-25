package com.urbanise.mmanchev.source.graph;

import com.urbanise.mmanchev.source.helpers.MemoryQueue;
import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.*;

/**
 * Created by mman on 25.02.17.
 */
public class DependencyGraph extends ADependencyGraph {
    private Map<String, List<String>> adjecancyMap = new HashMap<>();

    public DependencyGraph(String input) {
        super(input);
    }

    @Override
    public String build() {
        String[] feedLine;
        List<String> adjList;

        for (String s : getInput()) {
            feedLine = s.split(" ");
            adjList = new LinkedList<>();
            adjecancyMap.put(feedLine[0], adjList); // For the testing check for empty array or nulls

            for (int i = 1; i < feedLine.length; i++) {
                adjecancyMap.get(feedLine[0]).add(feedLine[i]);
            }
        }

        return asString();
    }

    /* Iterates the graph in Breadth-First-Search order and constructs a string representing the graph. */
    private String asString() {
        Iterator<String> adjMapKeySetIterator = adjecancyMap.keySet().iterator();
        MemoryQueue<String> queue = new MemoryQueue<>();
        StringBuilder sb = new StringBuilder();

        while (adjMapKeySetIterator.hasNext()) {
            String start = adjMapKeySetIterator.next();
            queue.offer(start);

            while (!queue.isEmpty()) {
                String s = queue.remove();
                sb.append(s + " ");
                List<String> dependencies = adjecancyMap.get(s);
                if (dependencies != null) {
                    dependencies.forEach(queue::offer);
                }
            }

            queue.clearMemory();
            sb.append(PrintUtils.NL);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner("");
    }
}
