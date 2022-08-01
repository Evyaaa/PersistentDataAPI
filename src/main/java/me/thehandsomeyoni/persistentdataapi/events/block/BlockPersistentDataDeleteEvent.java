package me.thehandsomeyoni.persistentdataapi.events.block;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.events.manager.PersistentDataEvent;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import java.io.Serializable;

/**
 * A custom event that is called when a block's persistent data is deleted.
 * @author TheHandsomeYoni
 * @since 1.8.0
 */
public class BlockPersistentDataDeleteEvent extends PersistentDataEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private AbstractPersistentData persistentData;
    private String dataName;
    private Serializable dataValue;
    private Block block;

    /**
     * Initializes the BlockPersistentDataDeleteEvent.
     * @param block The block that the persistent data is being deleted from.
     * @param persistentData The persistent data that is being deleted.
     */
    public BlockPersistentDataDeleteEvent(Block block, AbstractPersistentData persistentData) {
        super(persistentData);
        this.block = block;
        this.persistentData = persistentData;
        cancelled = false;
    }

    /**
     * Initializes the BlockPersistentDataDeleteEvent.
     * @param block The block that the persistent data is being deleted from.
     * @param dataName The name of the persistent data.
     */
    public BlockPersistentDataDeleteEvent(Block block, String dataName) {
        super(new PersistentData(dataName, null));
        this.block = block;
        this.persistentData = new PersistentData(dataName, dataValue);
        cancelled = false;
    }

    /**
     * Gets the persistent data that is being deleted.
     * @return The persistent data that is being deleted.
     */
    @Override
    public AbstractPersistentData getPersistentData() {
        return persistentData;
    }

    /**
     * Gets the name of the persistent data that was deleted.
     * @return The name of the persistent data that was deleted.
     */
    @Override
    public String getDataName() {
        return persistentData.getDataName();
    }

    /**
     * Gets the value of the persistent data that was deleted.
     * @return The value of the persistent data that was deleted.
     */
    @Override
    public Serializable getDataValue() {
        return persistentData.getDataValue();
    }

    /**
     * Checks if the event is cancelled.
     * @return True if the event is cancelled, false otherwise.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the event to cancelled.
     * @param cancel True if the event should be cancelled, false otherwise.
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * Gets handlers.
     * @return The handlers.
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
