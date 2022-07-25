package me.thehandsomeyoni.persistentdataapi;

import org.bukkit.persistence.PersistentDataType;

/**
 * A class that represents a persistent data.
 * @author TheHandsomeYoni
 * @since 1.1.0
 */
public abstract class AbstractPersistentData {
    protected String dataName;
    protected PersistentDataType dataType;
    protected Object dataValue;

    public <type, value> AbstractPersistentData(PersistentDataType<type, value> dataType, String dataName, value value){
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataValue = dataValue;
    }

    public abstract AbstractPersistentData changeDataValue(Object newDataValue);
    public abstract AbstractPersistentData getData();
    public abstract Object getDataValue();
    public abstract String getDataName();
    public abstract PersistentDataType getDataType();

}
