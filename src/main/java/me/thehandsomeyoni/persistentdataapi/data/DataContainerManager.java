package me.thehandsomeyoni.persistentdataapi.data;


import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static me.thehandsomeyoni.persistentdataapi.PersistentDataAPI.getJavaPlugin;
import static me.thehandsomeyoni.persistentdataapi.data.DataContainerManager.DataSerializer.deserialize;
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
        return deserialize(container.get(new NamespacedKey(getJavaPlugin(), key), PersistentDataType.BYTE_ARRAY));
    }

    /**
     * Gets the data associated with the given key in the given type.
     * @param key The key of the data.
     * @return The data in the given type.
     */
    public Serializable getUnserialized(NamespacedKey key){
        return deserialize(container.get(key, PersistentDataType.BYTE_ARRAY));
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

    /**
     * Simple serializer for serializing and deserializing data.
     * @author TheHandsomeYoni
     * @version 1.5.0
     */
    static class DataSerializer {
        private static ByteArrayOutputStream byteArrayOutput;
        private static ObjectOutputStream objectOutput;

        private static ByteArrayInputStream byteArrayInput;
        private static ObjectInputStream objectInput;


        /**
         * Turns the raw data into byte array.
         *
         * @param object The data.
         * @return The data in bytes.
         */
        public static byte[] serialize(Object object) {
            try {
                byteArrayOutput = new ByteArrayOutputStream();
                objectOutput = new ObjectOutputStream(byteArrayOutput);
                objectOutput.writeObject(object);
                objectOutput.flush();
                return byteArrayOutput.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * Turns the byte array into data.
         *
         * @param bytes The bytes.
         * @return The data.
         */
        public static Serializable deserialize(byte[] bytes) {
            byteArrayInput = new ByteArrayInputStream(bytes);
            try {
                objectInput = new ObjectInputStream(byteArrayInput);
                return (Serializable) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
