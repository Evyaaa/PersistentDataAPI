package me.thehandsomeyoni.persistentdataapi.api.handler;

import me.thehandsomeyoni.persistentdataapi.api.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.exceptions.DataDoesntExistException;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.thehandsomeyoni.persistentdataapi.PersistentDataAPI.getJavaPlugin;

/**
 * @author TheHandsomeYoni
 * @version 1.0
 */
public class DataRegistryHandler {
    private Player player;
    PersistentDataContainer dataContainer;

    /**
     * Initializes the DataRegistryHandler.
     * @param player The player that the data is stored in.
     */
    public DataRegistryHandler(Player player){
        this.player = player;
        this.dataContainer = player.getPersistentDataContainer();
    }

    /**
     * Registers a new data with the given name and type.
     * @param dataName the name of the data.
     * @param dataType the type of the data.
     * @param dataValue the value of the data.
     * @throws DataDoesntExistException
     */
    public void registerData(String dataName, PersistentDataType dataType, Object dataValue) throws DataDoesntExistException {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), dataType)){
            throw new DataDoesntExistException("The data already exists!");
        }
        dataContainer.set(new NamespacedKey(getJavaPlugin(), dataName), dataType, dataValue);
    }

    /**
     * Registers a new data from a class that extends AbstractPersistentData.
     * @param data The data that is being registered. This data must extend AbstractPersistentData.
     */
    public void registerData(AbstractPersistentData data) {
        dataContainer.set(new NamespacedKey(getJavaPlugin(),
                        data.getDataName()),
                        data.getDataType(),
                        data.getDataValue());
    }

    /**
     * Removes a data from the data container.
     * @param dataName The name of the data that is being removed.
     */
    public void unregisterData(String dataName, PersistentDataType type) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), type))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        dataContainer.remove(new NamespacedKey(getJavaPlugin(), dataName));
    }

    /**
     * Removes a data from the data container.
     * @param data The data that is being removed.
     */
    public void unregisterData(AbstractPersistentData data) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType()))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        dataContainer.remove(new NamespacedKey(getJavaPlugin(), data.getDataName()));
    }


    /**
     * Changes the values of a data.
     * @param data the data that is being changed.
     */
    public void setData(AbstractPersistentData data) {
        this.dataContainer
                .set(new NamespacedKey(getJavaPlugin(),
                                data.getDataName()),
                        data.getDataType(),
                        data.getDataValue());
    }

    /**
     * Changes the values of a data.
     * @param dataName name of the data that is being changed.
     * @param type the type of the data.
     * @param dataValue the new value of the data.
     */
    public void setData(String dataName, PersistentDataType type, Object dataValue) {
        this.dataContainer
                .set(new NamespacedKey(getJavaPlugin(), dataName), type, dataValue);
    }

    /**
     * Gets the value of a data.
     * @param dataName the name of the data.
     * @param dataType the type of the data.
     * @return the value of the data.
     * @throws DataDoesntExistException
     */
    public Object getData(String dataName, PersistentDataType dataType) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), dataType))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        return dataContainer.get(new NamespacedKey(getJavaPlugin(), dataName), dataType);
    }

    /**
     * Gets the value of a data.
     * @param data the data that is being gotten.
     * @return the value of the data.
     * @throws DataDoesntExistException
     */
    public Object getData(AbstractPersistentData data) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType()))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        return dataContainer.get(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType());
    }

    /**
     * Checks if a data exists.
     * @param dataName the name of the data.
     * @param type the type of the data.
     * @return true if the data exists, false if it doesn't.
     */
    public boolean dataExists(String dataName, PersistentDataType type) {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), type)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Checks if a data exists.
     * @param data the data that is being checked.
     * @return true if the data exists, false if it doesn't.
     */
    public boolean dataExists(AbstractPersistentData data) {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType())){
            return true;
        }else{
            return false;
        }
    }
}
