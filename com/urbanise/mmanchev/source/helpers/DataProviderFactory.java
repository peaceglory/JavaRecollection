package com.urbanise.mmanchev.source.helpers;

import com.urbanise.mmanchev.source.dataproviders.ConsoleDataInputProvider;
import com.urbanise.mmanchev.source.dataproviders.DataInputProvider;
import com.urbanise.mmanchev.source.dataproviders.FileDataInputProvider;
import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;


/**
 * Created by mman on 25.02.17.
 */
public class DataProviderFactory {

    public static DataInputProvider getDataProvider(String... commandLineArgs) throws DataSourceNotFound { // TODO add -h --help handler
        if (commandLineArgs == null || commandLineArgs.length == 0) {
            return new ConsoleDataInputProvider();
        }
        return new FileDataInputProvider(commandLineArgs[0]);
    }
}
