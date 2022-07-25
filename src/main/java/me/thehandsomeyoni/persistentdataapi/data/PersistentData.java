package me.thehandsomeyoni.persistentdataapi.data;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import org.bukkit.persistence.PersistentDataType;

/**
 * A class that represents a persistent data.
 * @author TheHandsomeYoni
 * @since 1.0
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


    public static AbstractPersistentData from(PersistentDataType dataType, String dataName, Object dataValue){
        return new PersistentData(dataType, dataName, dataValue);
    }
}
