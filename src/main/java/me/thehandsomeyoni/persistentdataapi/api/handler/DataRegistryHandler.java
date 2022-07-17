package me.thehandsomeyoni.persistentdataapi.api.handler;

import me.thehandsomeyoni.persistentdataapi.api.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.exceptions.DataDoesntExistException;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.thehandsomeyoni.persistentdataapi.PersistentDataAPI.getJavaPlugin;

public class DataRegistryHandler {
    private Player player;
    PersistentDataContainer dataContainer;

    public DataRegistryHandler(Player player){
        this.player = player;
        this.dataContainer = player.getPersistentDataContainer();
    }

    public void registerData(String dataName, PersistentDataType dataType, Object dataValue) throws DataDoesntExistException {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), dataType)){
            throw new DataDoesntExistException("The data already exists!");
        }
        dataContainer.set(new NamespacedKey(getJavaPlugin(), dataName), dataType, dataValue);
    }


    public void registerData(AbstractPersistentData data) {
        dataContainer.set(new NamespacedKey(getJavaPlugin(),
                        data.getDataName()),
                        data.getDataType(),
                        data.getDataValue());
    }


    public void unregisterData(String dataName, PersistentDataType type) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), type))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        dataContainer.remove(new NamespacedKey(getJavaPlugin(), dataName));
    }

    public void unregisterData(AbstractPersistentData data) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType()))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
    }


    public void setData(AbstractPersistentData data) {
        this.dataContainer
                .set(new NamespacedKey(getJavaPlugin(),
                                data.getDataName()),
                        data.getDataType(),
                        data.getDataValue());
    }

    public void setData(String dataName, PersistentDataType type, Object dataValue) {
        this.dataContainer
                .set(new NamespacedKey(getJavaPlugin(), dataName), type, dataValue);
    }

    public Object getData(String dataName, PersistentDataType dataType) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), dataType))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        return dataContainer.get(new NamespacedKey(getJavaPlugin(), dataName), dataType);
    }

    public Object getData(AbstractPersistentData data) throws DataDoesntExistException {
        if(!(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType()))){
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        return dataContainer.get(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType());
    }

    public boolean dataExists(String dataName, PersistentDataType type) {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), dataName), type)){
            return true;
        }else{
            return false;
        }
    }

    public boolean dataExists(AbstractPersistentData data) {
        if(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType())){
            return true;
        }else{
            return false;
        }
    }
}
