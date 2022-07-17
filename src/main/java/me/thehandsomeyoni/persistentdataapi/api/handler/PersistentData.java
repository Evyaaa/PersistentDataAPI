package me.thehandsomeyoni.persistentdataapi.api.handler;

import me.thehandsomeyoni.persistentdataapi.api.AbstractPersistentData;
import org.bukkit.persistence.PersistentDataType;

/**
 * @author TheHandsomeYoni
 * @version 1.0
 */
public class PersistentData extends AbstractPersistentData {

    /**
     * Initializes the PersistentData.
     * @param dataType The type of the data.
     * @param dataName The name of the data.
     * @param dataValue The value of the data.
     */
    public PersistentData(PersistentDataType dataType, String dataName, Object dataValue) {
        super(dataType, dataName, dataValue);
    }

    /**
     * Changes the value of the data.
     * @param newDataValue The new value of the data.
     * @return The new data with the new value.
     */
    @Override
    public AbstractPersistentData changeDataValue(Object newDataValue) {
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
    public Object getDataValue() {
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

    /**
     * Gets the type of the data.
     * @return The type of the data.
     */
    @Override
    public PersistentDataType getDataType() {
        return this.dataType;
    }
}
