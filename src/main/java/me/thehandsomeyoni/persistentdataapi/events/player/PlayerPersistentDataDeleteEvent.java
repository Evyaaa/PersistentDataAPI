package me.thehandsomeyoni.persistentdataapi.events.player;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.events.manager.PersistentDataEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.io.Serializable;

/**
 * A custom event that is called when a player's persistent data is written.
 * @author TheHandsomeYoni
 * @since 1.2.0
 */
public class PlayerPersistentDataDeleteEvent extends PersistentDataEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private AbstractPersistentData persistentData;
    private Player player;


    /**
     * Initializes the PlayerPersistentDataDeleteEvent.
     * @param player The player that the persistent data is being deleted from.
     * @param persistentData The persistent data that is being removed.
     */
    public PlayerPersistentDataDeleteEvent(Player player, AbstractPersistentData persistentData) {
        super(persistentData);
        this.persistentData = persistentData;
        this.player = player;
        cancelled = false;
    }

    /**
     * Initializes the PlayerPersistentDataDeleteEvent.
     * @param player The player that the persistent data is being deleted from.
     * @param dataName The name of the persistent data.
     */
    public PlayerPersistentDataDeleteEvent(Player player, String dataName) {
        super(new PersistentData(dataName, null));
        this.persistentData = new PersistentData(dataName, null);
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
     * Sets the event to cancel.
     * @param cancel true to cancel the event, false otherwise.
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
     * Gets the handlers.
     * @return The handlers.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the persistent data that is being deleted.
     * @return The persistent data.
     */
    public AbstractPersistentData getPersistentData() {
        return persistentData;
    }

    /**
     * Gets the data name of the persistent data.
     * @return The data name.
     */
    @Override
    public String getDataName() {
        return persistentData.getDataName();
    }

    /**
     * Gets the value of the persistent data.
     * @return The value.
     */
    @Override
    public Serializable getDataValue() {
        return persistentData.getDataValue();
    }

    /**
     * Gets the player that the persistent data is being deleted from.
     * @return The player.
     */
    public Player getPlayer() {
        return player;
    }

}
