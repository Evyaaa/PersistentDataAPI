package me.thehandsomeyoni.persistentdataapi.data;

import java.io.Serializable;
import java.util.Map;

/**
 * A class that represents special type of persistent data, that can be stored by serializing it.
 * @param <T> The original type of data. Must be specified to deserialize the data afterwards.
 */
public interface SerializablePersistentData<T> extends Serializable {

    /**
     * Serializes data to map, using the same way found in: {@link org.bukkit.configuration.serialization.ConfigurationSerializable}.
     * @return A map with all the data.
     */
    Map<String, Serializable> serialize();
}
