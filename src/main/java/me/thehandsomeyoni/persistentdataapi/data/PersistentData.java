package me.thehandsomeyoni.persistentdataapi.data;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;

/**
 * A class that represents a persistent data.
 * @author TheHandsomeYoni
 * @since 1.0
 */
public class PersistentData extends AbstractPersistentData {

    /**
     * Initializes the PersistentData.
     * @param dataName The name of the data.
     * @param dataValue The value of the data.
     */
    public PersistentData(String dataName, Serializable dataValue) {
        super(dataName, dataValue);
    }

    /**
     * Changes the value of the data.
     * @param newDataValue The new value of the data.
     * @return The new data with the new value.
     */
    @Override
    public AbstractPersistentData changeDataValue(Serializable newDataValue) {
        this.dataValue = newDataValue;
        return this;
    }

    /**
     * Gets the data.
     * @return The data.
     */
    @Override
    public AbstractPersistentData getData() {
        return this;
    }

    /**
     * Gets the value of the data.
     * @return The value of the data.
     */
    @Override
    public Serializable getDataValue() {
        return this.dataValue;
    }

    /**
     * Gets the name of the data.
     * @return The name of the data.
     */
    @Override
    public String getDataName() {
        return this.dataName;
    }
}
