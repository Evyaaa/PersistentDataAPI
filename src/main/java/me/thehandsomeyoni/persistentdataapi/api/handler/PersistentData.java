package me.thehandsomeyoni.persistentdataapi.api.handler;

import me.thehandsomeyoni.persistentdataapi.api.AbstractPersistentData;
import org.bukkit.persistence.PersistentDataType;

public class PersistentData extends AbstractPersistentData {

    public PersistentData(PersistentDataType dataType, String dataName, Object dataValue) {
        super(dataType, dataName, dataValue);
    }

    @Override
    public Object changeDataValue(Object newDataValue) {
        this.dataValue = newDataValue;
        return this.dataValue;
    }

    @Override
    public AbstractPersistentData getData() {
        return this;
    }

    @Override
    public Object getDataValue() {
        return this.dataValue;
    }

    @Override
    public String getDataName() {
        return this.dataName;
    }

    @Override
    public PersistentDataType getDataType() {
        return this.dataType;
    }
}
