package com.urbanise.mmanchev.source.visualizators;

import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mman on 25.02.17.
 */
public class SimpleVisualizator implements Visualizator {
    private final List<String> data;

    public SimpleVisualizator(String data) {
        this.data = format(data);
    }

    @Override
    public void visualize() {
        data.forEach(PrintUtils::print);
    }

    private List<String> format(String data) {
        Scanner s = new Scanner(data);
        List<String> result = new LinkedList<>();

        while (s.hasNextLine()) {
            result.add(s.nextLine());
            result.add(PrintUtils.NL);
        }

        return result;
    }

    public static void main(String[] args) {
        SimpleVisualizator sv = new SimpleVisualizator("ABC" + PrintUtils.NL + "DFR" + PrintUtils.NL + "RHFKFI");
        sv.visualize();
    }
}
