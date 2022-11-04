package me.thehandsomeyoni.persistentdataapi;

import me.thehandsomeyoni.persistentdataapi.exceptions.UnacceptableBlockException;
import me.thehandsomeyoni.persistentdataapi.manager.DataRegistry;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *  The class that initializes the API.
 * @author TheHandsomeYoni
 * @version 1.6.0
 */
public final class PersistentDataAPI {

    /** The borrowed java plugin */ protected JavaPlugin plugin;
    private static PersistentDataAPI instance;

    /**
     * Initializes the PersistentDataAPI.
     * @param plugin The plugin that the API is being used in.
     */
    public PersistentDataAPI(JavaPlugin plugin) {
        this.plugin = plugin;
        this.instance = this;
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
