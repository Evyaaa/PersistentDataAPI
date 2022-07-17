package me.thehandsomeyoni.persistentdataapi.api;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public abstract class AbstractPersistentData {
    protected String dataName;
    protected PersistentDataType dataType;
    protected Object dataValue;

    public AbstractPersistentData(PersistentDataType dataType, String dataName, Object dataValue){
        if(!(dataValue instanceof long[] || dataValue instanceof String
                || dataValue instanceof Integer || dataValue instanceof Long
                || dataValue instanceof int[] || dataValue instanceof Short
                || dataValue instanceof PersistentDataContainer || dataValue instanceof PersistentDataContainer[]
                || dataValue instanceof Byte || dataValue instanceof byte[]
                || dataValue instanceof Float)){
            throw new IllegalArgumentException("An invalid type of data was found!");
        }
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataValue = dataValue;
    }

    public abstract Object changeDataValue(Object newDataValue);
    public abstract AbstractPersistentData getData();
    public abstract Object getDataValue();
    public abstract String getDataName();
    public abstract PersistentDataType getDataType();

}
