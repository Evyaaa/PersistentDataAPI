package me.thehandsomeyoni.persistentdataapi.exceptions;

/**
 * A class that represents an exception that is thrown when the block is not acceptable or does not accept persistent data container.
 * @author TheHandsomeYoni
 * @since 1.8.0
 */
public class UnacceptableBlockException extends Exception {

    /**
     * Initializes the UnacceptableBlockException.
     */
    public UnacceptableBlockException() {
        super("This block cannot store persistent data!");
        this.printStackTrace();
    }
}
