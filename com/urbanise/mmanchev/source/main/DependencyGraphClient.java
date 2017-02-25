package com.urbanise.mmanchev.source.main;

import com.urbanise.mmanchev.source.dataproviders.DataInputProvider;
import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;
import com.urbanise.mmanchev.source.graph.DependencyGraph;
import com.urbanise.mmanchev.source.graph.SimpleDependencyGraph;
import com.urbanise.mmanchev.source.helpers.DataProviderFactory;
import com.urbanise.mmanchev.source.utils.PrintUtils;
import com.urbanise.mmanchev.source.visualizators.SimpleVisualizator;
import com.urbanise.mmanchev.source.visualizators.Visualizator;

/**
 * Created by mman on 25.02.17.
 */
public class DependencyGraphClient {

    public static void main(String[] args)  {
        DataInputProvider input = null;
        try {
            input = DataProviderFactory.getDataProvider(args);
        } catch (DataSourceNotFound e) {
            PrintUtils.printLine(e.getMessage());
            System.exit(-1);
        }
        DependencyGraph dependencyGraph = new SimpleDependencyGraph(input.provide());
        Visualizator visualizator = new SimpleVisualizator(dependencyGraph.build());

        visualizator.visualize();
    }
}
