package me.thehandsomeyoni.persistentdataapi.data;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.events.ItemPersistentDataDeleteEvent;
import me.thehandsomeyoni.persistentdataapi.events.ItemPersistentDataWriteEvent;
import me.thehandsomeyoni.persistentdataapi.events.PlayerPersistentDataDeleteEvent;
import me.thehandsomeyoni.persistentdataapi.events.PlayerPersistentDataWriteEvent;
import me.thehandsomeyoni.persistentdataapi.exceptions.DataDoesntExistException;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import static me.thehandsomeyoni.persistentdataapi.PersistentDataAPI.getJavaPlugin;
import static me.thehandsomeyoni.persistentdataapi.data.PersistentData.from;

/**
 * Handles all persistent data registry operations.
 * @author TheHandsomeYoni
 * @since 1.0
 */
public class DataRegistry {
    private Player player;
    private ItemStack item;
    private ItemMeta meta;
    PersistentDataContainer dataContainer;

    /**
     * Initializes the DataRegistry of a player.
     * @param player The player that the data is stored in.
     */
    public DataRegistry(Player player){
        this.player = player;
        this.dataContainer = player.getPersistentDataContainer();
    }

    /**
     * Initializes the DataRegistry of an item.
     * @param item The item that the data is stored in.
     */
    public DataRegistry(ItemStack item){
        this.item = item;
        this.meta = item.getItemMeta();
        this.dataContainer = meta.getPersistentDataContainer();
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
        if(player != null){
            PlayerPersistentDataWriteEvent event = new PlayerPersistentDataWriteEvent(player, from(dataType, dataName, dataValue));
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataWriteEvent event = new ItemPersistentDataWriteEvent(item, from(dataType, dataName, dataValue));
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
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
        if(player != null){
            PlayerPersistentDataWriteEvent event = new PlayerPersistentDataWriteEvent(player, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataWriteEvent event = new ItemPersistentDataWriteEvent(item, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
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
        if(player != null){
            PlayerPersistentDataDeleteEvent event = new PlayerPersistentDataDeleteEvent(player, type, dataName);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataDeleteEvent event = new ItemPersistentDataDeleteEvent(item, type, dataName);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
    }

    /**
     * Removes a data from the data container.
     * @param data The data that is being removed.
     */
    public void unregisterData(AbstractPersistentData data) throws DataDoesntExistException {
        if (!(dataContainer.has(new NamespacedKey(getJavaPlugin(), data.getDataName()), data.getDataType()))) {
            throw new DataDoesntExistException("Data doesn't exist or couldn't be found");
        }
        dataContainer.remove(new NamespacedKey(getJavaPlugin(), data.getDataName()));
        if(player != null){
            PlayerPersistentDataDeleteEvent event = new PlayerPersistentDataDeleteEvent(player, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataDeleteEvent event = new ItemPersistentDataDeleteEvent(item, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
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
        if(player != null){
            PlayerPersistentDataWriteEvent event = new PlayerPersistentDataWriteEvent(player, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataWriteEvent event = new ItemPersistentDataWriteEvent(item, data);
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
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
        if(player != null){
            PlayerPersistentDataWriteEvent event = new PlayerPersistentDataWriteEvent(player, from(type, dataName, dataValue));
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }

        if (item != null) {
            ItemPersistentDataWriteEvent event = new ItemPersistentDataWriteEvent(item, from(type, dataName, dataValue));
            getJavaPlugin().getServer().getPluginManager().callEvent(event);
        }
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
