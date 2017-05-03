package oop.atm.exceptions;

/**
 * Created by mman on 19.02.17.
 */
public class InsufficientCashStorageException extends Exception {

    public InsufficientCashStorageException(String message) {
        super(message);
    }
}
