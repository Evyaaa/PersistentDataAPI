package me.thehandsomeyoni.persistentdataapi;

import me.thehandsomeyoni.persistentdataapi.exceptions.UnacceptableBlockException;
import me.thehandsomeyoni.persistentdataapi.manager.DataRegistry;
import me.thehandsomeyoni.persistentdataapi.manager.SerializableBukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *  The class that initializes the API.
 * @author TheHandsomeYoni
 * @version 2.0.2
 */
public final class PersistentDataAPI {

    /** The borrowed java plugin */
    private JavaPlugin plugin;
    private static PersistentDataAPI instance;

    /**
     * Initializes the PersistentDataAPI.
     * @param plugin The plugin that the API is being used in.
     */
    public PersistentDataAPI(JavaPlugin plugin) {
        this.plugin = plugin;
        instance = this;
    }

    /**
     * Gets the instance of the DataRegistry.
     * @return The DataRegistry of the given player.
     */
    public DataRegistry getDataRegistry(Player player){
       return new DataRegistry(player);
    }

    /**
     * Gets the instance of the DataRegistry.
     * @param item The DataRegistry of the given item.
     * @return The DataRegistry of the given item.
     */
    public DataRegistry getDataRegistry(ItemStack item){ return new DataRegistry(item); }

    /**
     * Gets the instance of the DataRegistry.
     * @param block The DataRegistry of the given block.
     * @return The DataRegistry of the given block.
     */
    public DataRegistry getDataRegistry(Block block) throws UnacceptableBlockException { return new DataRegistry(block); }

    /**
     * Gets the instance of BukkitSerializer to a given data container.
     * @param container The given data container.
     * @return The BukkitSerializer to the given data container.
     */
    public SerializableBukkit getBukkitSerializer(PersistentDataContainer container) { return new SerializableBukkit(container); }


    /**
     * Gets the instance of the PersistentDataAPI.
     * @return The instance of the PersistentDataAPI.
     */
    public static PersistentDataAPI getInstance() {
        return PersistentDataAPI.instance;
    }

    /**
     * Gets the plugin that the API is being used in.
     * @return The plugin that the API is being used in.
     */
    public static JavaPlugin getJavaPlugin() {
        return PersistentDataAPI.getInstance().plugin;
    }

}
