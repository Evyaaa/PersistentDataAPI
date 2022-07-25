package me.thehandsomeyoni.persistentdataapi.exceptions;

/**
 * This exception is thrown when a persistent data requested doesn't exist.
 * @author TheHandsomeYoni
 * @since 1.0.0
 */
public class DataDoesntExistException extends Exception {

    public DataDoesntExistException(String message) {
        super(message);
        this.initCause(new Throwable("Data can't be found, or doesn't exist"));
    }
}

