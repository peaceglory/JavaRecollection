package com.urbanise.mmanchev.source.helpers;

import com.urbanise.mmanchev.source.dataproviders.ConsoleDataInputProvider;
import com.urbanise.mmanchev.source.dataproviders.DataInputProvider;
import com.urbanise.mmanchev.source.dataproviders.FileDataInputProvider;
import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;

import java.io.IOException;


/**
 * A data provider static factory.
 *
 * @author mmanchev, 25.02.17
 */
public class DataProviderFactory {

    /**
     * Constructs a concrete data provider object based on user command line arguments.
     *
     * @param commandLineArgs if no command line arguments are present the data is provided via user console. Otherwise
     *                        data is provided with a file (represented by the first command line arg).
     * @return appropriate data input provider to work with.
     * @throws DataSourceNotFound if a file name is provided as a command line argument but the file does not exist.
     * @throws IOException if a file name is provided as a command line arguments but reading the file fails.
     */
    public static DataInputProvider getDataProvider(String... commandLineArgs) throws DataSourceNotFound, IOException {
        if (commandLineArgs == null || commandLineArgs.length == 0) {
            return new ConsoleDataInputProvider();
        }
        return new FileDataInputProvider(commandLineArgs[0]);
    }
}
