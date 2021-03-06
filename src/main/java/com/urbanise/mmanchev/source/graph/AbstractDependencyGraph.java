package com.urbanise.mmanchev.source.graph;

import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Abstract class responsible for formating and holding the dependency data.
 *
 * @author mmanchev, 25.02.17
 */
public abstract class AbstractDependencyGraph implements DependencyGraph {
    private final List<String> input;

    public AbstractDependencyGraph(String input) {
        this.input = format(input);
    }

    protected List<String> getInput() {
        return this.input;
    }

    private List<String> format(String input) {
        try (Scanner scan = new Scanner(input)) {
            List<String> result = new LinkedList<>();

            while (scan.hasNextLine()) {
                result.add(scan.nextLine());
                if (!scan.hasNextLine()) {
                    break;
                }
                result.add(PrintUtils.NL);
            }
            return result;
        }
    }

}
