package me.thehandsomeyoni.persistentdataapi.events;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.events.manager.PersistentDataEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

/**
 * A custom event that is called when an item's persistent data is written.
 * @author TheHandsomeYoni
 * @since 1.2.0
 */
public class ItemPersistentDataDeleteEvent extends PersistentDataEvent {


    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private AbstractPersistentData persistentData;
    private String dataName;
    private PersistentDataType type;
    private Object dataValue;
    private ItemStack itemStack;
    private ItemMeta meta;


    /**
     * Initializes the PlayerPersistentDataDeleteEvent.
     * @param item The item that the persistent data is being deleted from.
     * @param persistentData The persistent data that is being deleted.
     */
    public ItemPersistentDataDeleteEvent(ItemStack item, AbstractPersistentData persistentData) {
        super (persistentData);
        this.persistentData = persistentData;
        this.itemStack = item;
        cancelled = false;
    }

    /**
     * Initializes the PlayerPersistentDataDeleteEvent.
     * @param item The item that the persistent data is being deleted from.
     * @param type The type of the persistent data.
     * @param dataName The name of the persistent data.
     */
    public ItemPersistentDataDeleteEvent(ItemStack item, PersistentDataType type, String dataName) {
        super(PersistentData.from(type, dataName, null));
        this.persistentData = PersistentData.from(type, dataName, null);
        this.itemStack = item;
        cancelled = false;
    }

    /**
     * Gets the handlers of the event.
     * @return The handlers of the event.
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Checks if the event is being cancelled.
     * @return true if the event is being cancelled, false otherwise.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancels the event.
     * @param cancel true to cancel the event, false otherwise.
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }


    /**
     * Static method to get the handlers.
     * @return The handlers.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the persistent data deleted in the event.
     * @return The persistent data.
     */
    public AbstractPersistentData getPersistentData() {
        return persistentData;
    }

    /**
     * Gets the data name of the persistent data.
     * @return The data name.
     */
    public String getDataName() {
        this.dataName = persistentData.getDataName();
        return dataName;
    }

    /**
     * Changes the data name of the persistent data.
     * @param dataName The new data name.
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * Gets the data type of the persistent data.
     * @return The data type.
     */
    public PersistentDataType getType() {
        this.type = persistentData.getDataType();
        return type;
    }

    /**
     * Changes the data type of the persistent data.
     * @param type The new data type.
     */
    public void setType(PersistentDataType type) {
        this.type = type;
    }

    /**
     * Gets the data value of the persistent data.
     * @return The data value.
     */
    public Object getDataValue() {
        this.dataValue = persistentData.getDataValue();
        return dataValue;
    }

    /**
     * Changes the data value of the persistent data.
     * @param dataValue The new data value.
     */
    public void setDataValue(Object dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * Gets the item's persistent data.
     * @return The player's persistent data.
     */
    public PersistentDataContainer getPersistentDataContainer() {
        return itemStack.getItemMeta().getPersistentDataContainer();
    }

    /**
     * Gets the item that the persistent data is being deleted from.
     * @return The item.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }
}
