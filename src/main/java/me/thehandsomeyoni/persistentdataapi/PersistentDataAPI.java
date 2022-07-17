package me.thehandsomeyoni.persistentdataapi;

import me.thehandsomeyoni.persistentdataapi.api.handler.DataRegistryHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author TheHandsomeYoni
 * @version 1.0
 */
public final class PersistentDataAPI {

    protected JavaPlugin plugin;
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
     * Gets the instance of the PersistentDataAPI.
     * @return The instance of the PersistentDataAPI.
     */
    public DataRegistryHandler getDataRegistry(Player player){
       return new DataRegistryHandler(player);
    }



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
