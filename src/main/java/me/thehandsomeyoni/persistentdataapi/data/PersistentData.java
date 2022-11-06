package me.thehandsomeyoni.persistentdataapi.data;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * Serializes data to map, using the same way found in: {@link ConfigurationSerializable}.
     *
     * @return A map with all the data.
     */
    @Override
    public Map<String, Serializable> serialize() {
        Map<String, Serializable> map = new HashMap<>();

        map.put("dataName", this.dataName);
        map.put("dataValue", this.dataValue);

        return map;
    }

    /**
     * Deserializes data from map
     *
     * @param map The map with all the data.
     * @return The deserialized data.
     */
    public static PersistentData deserialize(Map<String, Serializable> map) {
        return new PersistentData(map.get("dataName").toString(), map.get("dataValue"));
    }
}
