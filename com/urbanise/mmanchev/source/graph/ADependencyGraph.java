package com.urbanise.mmanchev.source.graph;

import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mman on 25.02.17.
 */
public abstract class ADependencyGraph implements IDependencyGraph {
    private final List<String> input;

    public ADependencyGraph(String input) {
        this.input = format(input);
    }

    protected List<String> getInput() {
        return this.input;
    }

    private List<String> format(String input) {
        try (Scanner s = new Scanner(input)) {
            List<String> result = new LinkedList<>();

            while (s.hasNextLine()) {
                result.add(s.nextLine());
                result.add(PrintUtils.NL);
            }
            return result;
        }
    }

}
