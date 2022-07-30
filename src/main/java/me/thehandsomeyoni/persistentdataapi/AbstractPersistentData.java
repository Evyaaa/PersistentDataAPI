package me.thehandsomeyoni.persistentdataapi;

import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;

/**
 * A class that represents a persistent data.
 * @author TheHandsomeYoni
 * @since 1.0
 */
public abstract class AbstractPersistentData {
    protected String dataName;
    protected Serializable dataValue;

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

    public abstract AbstractPersistentData changeDataValue(Serializable newDataValue);
    public abstract AbstractPersistentData getData();
    public abstract Serializable getDataValue();
    public abstract String getDataName();

}
