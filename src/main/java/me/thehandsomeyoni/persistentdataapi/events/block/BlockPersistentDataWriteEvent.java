package me.thehandsomeyoni.persistentdataapi.events.block;

import me.thehandsomeyoni.persistentdataapi.AbstractPersistentData;
import me.thehandsomeyoni.persistentdataapi.data.PersistentData;
import me.thehandsomeyoni.persistentdataapi.events.manager.PersistentDataEvent;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.io.Serializable;

/**
 * A custom event that is called when a block's persistent data is written.
 * @author TheHandsomeYoni
 * @since 1.8.0
 */
public class BlockPersistentDataWriteEvent extends PersistentDataEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private AbstractPersistentData persistentData;
    private String dataName;
    private Serializable dataValue;
    Block block;

    /**
     * Initializes the BlockPersistentDataWriteEvent.
     * @param block The block that the persistent data is being written to.
     * @param persistentData The persistent data that is being written.
     */
    public BlockPersistentDataWriteEvent(Block block, AbstractPersistentData persistentData) {
        super(persistentData);
        this.block = block;
        this.persistentData = persistentData;
        cancelled = false;
    }

    /**
     * Initializes the BlockPersistentDataWriteEvent.
     * @param block The block that the persistent data is being written to.
     * @param dataName The name of the persistent data.
     * @param dataValue The value of the persistent data.
     */
    public BlockPersistentDataWriteEvent(Block block, String dataName, Serializable dataValue) {
        super(new PersistentData(dataName, dataValue));
        this.block = block;
        this.persistentData = new PersistentData(dataName, dataValue);
        cancelled = false;
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

    /**
     * Gets the persistent data.
     * @return The persistent data.
     */
    @Override
    public AbstractPersistentData getPersistentData() {
        return persistentData;
    }

    /**
     * gets the name of the written data
     * @return the name of the written data
     */
    @Override
    public String getDataName() {
        return persistentData.getDataName();
    }

    /**
     * gets the value of the written data
     * @return the value of the written data
     */
    @Override
    public Serializable getDataValue() {
        return persistentData.getDataValue();
    }

    /**
     * Gets the associated block.
     * @return The associated block.
     */
    public Block getBlock() {
        return block;
    }
}
