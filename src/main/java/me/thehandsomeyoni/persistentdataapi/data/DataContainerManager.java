package me.thehandsomeyoni.persistentdataapi.data;


import me.thehandsomeyoni.persistentdataapi.manager.DataSerializer;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static me.thehandsomeyoni.persistentdataapi.PersistentDataAPI.getJavaPlugin;
import static me.thehandsomeyoni.persistentdataapi.manager.DataSerializer.serialize;

public class DataContainerManager  {
    private PersistentDataContainer container;

    /**
     * Initializes the DataContainerManager for a given persistent data.
     * @param container The persistent data container.
     */
    public DataContainerManager(PersistentDataContainer container) {
        this.container = container;
    }

    /**
     * Serializes and writes the data in the container.
     * @param key The key of the data.
     * @param value The value of the data.
     */
    public void setSerialized (String key, Serializable value) {
        container.set(new NamespacedKey(getJavaPlugin(), key),PersistentDataType.BYTE_ARRAY , serialize(value));
    }

    /**
     * Gives the data associated with the given key in bytes.
     * @param key The key of the data.
     * @return The data in bytes.
     */
    public byte[] getSerialized (String key) {
        return container.get(new NamespacedKey(getJavaPlugin(), key), PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Gives the data associated with the given key in the given type.
     * @param key The key of the data.
     * @return The data in the given type.
     */
    public Serializable getUnserialized(String key){
        return DataSerializer.deserialize(container.get(new NamespacedKey(getJavaPlugin(), key), PersistentDataType.BYTE_ARRAY));
    }

    /**
     * Gets the data associated with the given key in the given type.
     * @param key The key of the data.
     * @return The data in the given type.
     */
    public Serializable getUnserialized(NamespacedKey key){
        return DataSerializer.deserialize(container.get(key, PersistentDataType.BYTE_ARRAY));
    }

    public Set<String> getAllKeys(){
        Set<String> keys = new HashSet<>();

        container.getKeys().forEach(key -> {
            keys.add(key.getKey());
        });

        return keys;
    }

    public HashMap<String, Serializable> getAll(){
        HashMap<String, Serializable> data = new HashMap<>();

        container.getKeys().forEach(key -> {
            data.put(key.getKey(), getUnserialized(key));
        });

        return data;
    }

    /**
     * Deletes the data associated with the given key.
     * @param key The key of the data.
     */
    public void remove(String key){
        container.remove(new NamespacedKey(getJavaPlugin(), key));
    }

    /**
     * Gives the persistent data container.
     * @return The persistent data container.
     */
    public PersistentDataContainer getContainer() {
        return container;
    }

    /**
     * Checks if the data associated with the given key exists.
     * @return True if the data exists, false otherwise.
     */
    public boolean has(String key){
        return container.has(new NamespacedKey(getJavaPlugin(), key), PersistentDataType.BYTE_ARRAY);
    }

}
