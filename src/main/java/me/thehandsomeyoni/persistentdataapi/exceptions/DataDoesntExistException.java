package me.thehandsomeyoni.persistentdataapi.exceptions;

public class DataDoesntExistException extends Exception {

    public DataDoesntExistException(String message) {
        super(message);
        this.initCause(new Throwable("Data can't be found, or doesn't exist"));
    }
}

