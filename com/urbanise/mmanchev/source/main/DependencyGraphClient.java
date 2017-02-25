package com.urbanise.mmanchev.source.main;

import com.urbanise.mmanchev.source.dataproviders.ConsoleDataInputProvider;
import com.urbanise.mmanchev.source.dataproviders.DataInputProvider;
import com.urbanise.mmanchev.source.graph.DependencyGraph;
import com.urbanise.mmanchev.source.graph.IDependencyGraph;
import com.urbanise.mmanchev.source.visualizators.SimpleVisualizator;
import com.urbanise.mmanchev.source.visualizators.Visualizator;

/**
 * Created by mman on 25.02.17.
 */
public class DependencyGraphClient {

    public static void main(String[] args) {
        DataInputProvider inputProvider = new ConsoleDataInputProvider();

        IDependencyGraph dependencyGraph = new DependencyGraph(inputProvider.provide());

        Visualizator visualizator = new SimpleVisualizator(dependencyGraph.build());

        visualizator.visualize();
    }
}
