package me.thehandsomeyoni.persistentdataapi;

import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.data.SerializablePersistentData;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;

/**
 * A class that represents a persistent data.
 * @author TheHandsomeYoni
 * @since 1.0
 */
public abstract class AbstractPersistentData implements SerializablePersistentData<AbstractPersistentData> {
    /** The name of the data associated with the persistent data */ protected String dataName;
    /** The value of the data associated with the persistent data */ protected Serializable dataValue;

    /**
     * Initializes the PersistentData.
     * @param dataName The name of the data.
     * @param dataValue The value of the data, must be serializable.
     */
    public AbstractPersistentData(String dataName, Serializable dataValue) {
        this.dataName = dataName;
        this.dataValue = dataValue;
    }



    /*
    Old constructor
    public <type, value> AbstractPersistentData(PersistentDataType<type, value> dataType, String dataName, value value){
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataValue = dataValue;
    }
    */

    /**
     * Changes the value of the persistent data.
     * @param newDataValue The new value of the data.
     * @return The persistent data with the new value.
     */
    public abstract AbstractPersistentData changeDataValue(Serializable newDataValue);

    /**
     * Gets the data.
     * @return The data.
     */
    public abstract AbstractPersistentData getData();

    /**
     * Gets the value of the data.
     * @return The value of the data.
     */
    public abstract Serializable getDataValue();

    /**
     * Gets the name of the data.
     * @return The name of the data.
     */
    public abstract String getDataName();

}
