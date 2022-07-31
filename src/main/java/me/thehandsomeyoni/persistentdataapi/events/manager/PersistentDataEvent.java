package me.thehandsomeyoni.persistentdataapi.events.manager;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;

/**
 * A class that represents a persistent data event.
 * @author TheHandsomeYoni
 * @since 1.6.0
 */
public abstract class PersistentDataEvent extends Event implements Cancellable {
    private AbstractPersistentData persistentData;

    /**
     * Initializes the PersistentDataEvent with persistentData.
     * @param persistentData The persistent data that is being manipulated.
     */
    public PersistentDataEvent(AbstractPersistentData persistentData) {
        this.persistentData = persistentData;
    }

    /**
     * Initializes the PersistentDataEvent with given data values.
     * @param dataName The name of the data.
     * @param dataValue The value of the data.
     */
    public PersistentDataEvent( String dataName, Serializable dataValue) {
        this.persistentData = new PersistentData(dataName, dataValue);
    }

    /**
     * Gets the persistent data.
     * @return The persistent data.
     */
    public AbstractPersistentData getPersistentData() {
        return persistentData;
    }

    /**
     * Gets the name of the data.
     * @return The name of the data.
     */
    public String getDataName() {
        return persistentData.getDataName();
    }

    /**
     * Gets the value of the data.
     * @return The value of the data.
     */
    public Object getDataValue() {
        return persistentData.getDataValue();
    }
}
