package com.urbanise.mmanchev.source.exceptions;

/**
 * Exception indicating that a data source (e.g. a file) cannot be found.
 *
 * @author mmanchev, 25.02.17
 */
public class DataSourceNotFound extends Exception {

    public DataSourceNotFound(String message) {
        super(message);
    }
}
