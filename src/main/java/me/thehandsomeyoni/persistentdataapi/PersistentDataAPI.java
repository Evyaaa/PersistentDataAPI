package me.thehandsomeyoni.persistentdataapi;

import me.thehandsomeyoni.persistentdataapi.api.handler.DataRegistryHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PersistentDataAPI {
    protected JavaPlugin plugin;
    private static PersistentDataAPI instance;

    public PersistentDataAPI(JavaPlugin plugin) {
        this.plugin = plugin;
        this.instance = this;
    }

    public DataRegistryHandler getDataRegistry(Player player){
       return new DataRegistryHandler(player);
    }



    public static PersistentDataAPI getInstance() {
        return PersistentDataAPI.instance;
    }

    public static JavaPlugin getJavaPlugin() {
        return PersistentDataAPI.getInstance().plugin;
    }









}
