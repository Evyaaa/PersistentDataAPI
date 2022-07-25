package me.thehandsomeyoni.persistentdataapi.events;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.events.manager.PersistentDataEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

/**
 * A custom event that is called when a player's persistent data is written.
 * @author TheHandsomeYoni
 * @since 1.2.0
 */
public class PlayerPersistentDataWriteEvent extends PersistentDataEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private AbstractPersistentData persistentData;
    private String dataName;
    private PersistentDataType type;
    private Object dataValue;
    private Player player;


    /**
     * Initializes the PlayerPersistentDataWriteEvent.
     * @param player The player that the persistent data is being written to.
     * @param persistentData The persistent data that is being written.
     */
    public PlayerPersistentDataWriteEvent(Player player, AbstractPersistentData persistentData) {
        super(persistentData);
        this.persistentData = persistentData;
        this.player = player;
        cancelled = false;
    }

    /**
     * Initializes the PlayerPersistentDataWriteEvent.
     * @param player The player that the persistent data is being written to.
     * @param type The type of the persistent data.
     * @param dataName The name of the persistent data.
     * @param dataValue The value of the persistent data.
     */
    public PlayerPersistentDataWriteEvent(Player player, PersistentDataType type, String dataName, Object dataValue) {
        super(PersistentData.from(type, dataName, dataValue));
        this.persistentData = PersistentData.from(type, dataName, dataValue);
        this.player = player;
        cancelled = false;
    }

    /**
     * Checks if the event is cancelled.
     * @return true if the event is cancelled, false otherwise.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancels the event.
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * Gets the handlers.
     * @return The handlers.
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Static method to get the handlers.
     * @return The handlers.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the persistent data written in the event.
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
     * Gets the data type of the persistent data.
     * @return The data type.
     */
    public PersistentDataType getType() {
        this.type = persistentData.getDataType();
        return type;
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
     * Gets the player's persistent data.
     * @return The player's persistent data.
     */
    public PersistentDataContainer getPersistentDataContainer() {
        return player.getPersistentDataContainer();
    }

    /**
     * Gets the player that the persistent data is being written to.
     * @return The player.
     */
    public Player getPlayer() {
        return player;
    }


}
