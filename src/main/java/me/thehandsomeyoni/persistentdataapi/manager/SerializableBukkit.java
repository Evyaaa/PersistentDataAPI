package me.thehandsomeyoni.persistentdataapi.manager;

import me.thehandsomeyoni.persistentdataapi.data.DataContainerManager;
import org.bukkit.*;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static me.thehandsomeyoni.persistentdataapi.manager.SerializableBukkit.StorageUtilities.*;


/**
 * A class with default methods to store and get serializable Bukkit classes.
 * @author TheHandsomeYoni
 * @since 1.9.0
 */
public class SerializableBukkit {
    private DataContainerManager manager;
    private PersistentDataContainer container;

    /**
     * Initializes the class.
     * @param container The persistent data container that will be affected.
     */
    public SerializableBukkit(PersistentDataContainer container) {
        this.manager = new DataContainerManager(container);
        this.container = container;
    }

    /**
     * Stores an ItemStack in the given data container with the given key.
     * @param itemStack The ItemStack to be stored.
     * @param key The key of the data.
     */
    public void storeItemStack(ItemStack itemStack, String key) {
        manager.setSerialized(key, itemStack.serialize().toString());
    }

    /**
     * Gives back the ItemStack stored in the given data container with the given key.
     * If the key is not found, it returns null.
     * @param key The key of the data.
     * @return The ItemStack stored in the given data container with the given key.
     */
    public ItemStack getItemStack(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> item = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return ItemStack.deserialize(item);
    }

    /**
     * Stores an Inventory in the given data container with the given key.
     * @param inventory The Inventory to store.
     * @param key The key of the data.
     */
    public void storeInventory(Inventory inventory, String key) {
        manager.setSerialized(key, toBase64(inventory));
    }

    /**
     * Gives back the Inventory stored in the given data container with the given key.
     * If the key is not found, it returns null.
     * @param key The key of the data.
     * @return The Inventory stored in the given data container with the given key.
     */
    public Inventory getInventory(String key) {
        if (!manager.has(key)) return null;

        return fromBase64(manager.getDeserialized(key).toString());
    }

    /**
     * Stores a Location in the given data container with the given key.
     * @param location The Location to store.
     * @param key The key of the data.
     */
    public void storeLocation(Location location, String key) {
        manager.setSerialized(key, location.serialize().toString());
    }

    /**
     * Gives back the Location stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The Location stored in the given data container with the given key.
     */
    public Location getLocation(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> location = deserializeBukkitMap(manager.getDeserialized(key).toString());
        World world = Bukkit.getWorld("world");
        return Location.deserialize(location);
    }

    /**
     * Stores a Vector in the given data container with the given key.
     * @param vector The Vector to store.
     * @param key The key of the data.
     */
    public void storeVector(Vector vector, String key) {
        manager.setSerialized(key, vector.serialize().toString());
    }

    /**
     * Gives back the Vector stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The Vector stored in the given data container with the given key.
     */
    public Vector getVector(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> vector = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return Vector.deserialize(vector);
    }

    /**
     * Stores a PotionEffect in the given data container with the given key.
     * @param potionEffect The PotionEffect to store.
     * @param key The key of the data.
     */
    public void storePotionEffect(PotionEffect potionEffect, String key) {
        manager.setSerialized(key, potionEffect.serialize().toString());
    }

/**
     * Gives back the PotionEffect stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The PotionEffect stored in the given data container with the given key.
     */
    public PotionEffect getPotionEffect(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> potionEffect = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return new PotionEffect(potionEffect);
    }

    /**
     * Stores a BlockVector in the given data container with the given key.
     * @param blockVector The BlockVector to store.
     * @param key The key of the data.
     */
    public void storeBlockVector(BlockVector blockVector, String key) {
        manager.setSerialized(key, blockVector.serialize().toString());
    }

    /**
     * Gives back the BlockVector stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The BlockVector stored in the given data container with the given key.
     */
    public BlockVector getBlockVector(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> blockVector = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return BlockVector.deserialize(blockVector);
    }

    /**
     * Stores a Color in the given data container with the given key.
     * @param color The Color to store.
     * @param key The key of the data.
     */
    public void storeColor(Color color, String key) {
        manager.setSerialized(key, color.serialize().toString());
    }

    /**
     * Gives back the Color stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The Color stored in the given data container with the given key.
     */
    public Color getColor(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> color = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return Color.deserialize(color);
    }

    /**
     * Stores a Pattern in the given data container with the given key.
     * @param pattern The Pattern to store.
     * @param key The key of the data.
     */
    public void storePattern(Pattern pattern, String key) {
        manager.setSerialized(key, pattern.serialize().toString());
    }

    /**
     * Gives back the Pattern stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The Pattern stored in the given data container with the given key.
     */
    public Pattern getPattern(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> pattern = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return new Pattern(pattern);
    }

    /**
     * Stores an AttributeModifier in the given data container with the given key.
     * @param attributeModifier The AttributeModifier to store.
     * @param key The key of the data.
     */
    public void storeAttributeModifier(AttributeModifier attributeModifier, String key) {
        manager.setSerialized(key, attributeModifier.serialize().toString());
    }

    /**
     * Gives back the AttributeModifier stored in the given data container with the given key.
     * @param key The key of the data.
     * @return The AttributeModifier stored in the given data container with the given key.
     */
    public AttributeModifier getAttributeModifier(String key) {
        if (!manager.has(key)) return null;

        Map<String, Object> attributeModifier = deserializeBukkitMap(manager.getDeserialized(key).toString());

        return AttributeModifier.deserialize(attributeModifier);
    }

    static class StorageUtilities {

        // Serializer wasn't taken from ItzGuy. I swear.
        public static String toBase64(Inventory inventory) throws IllegalStateException {
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
                dataOutput.writeInt(inventory.getSize());
                for (int i = 0; i < inventory.getSize(); i++)
                    dataOutput.writeObject(inventory.getItem(i));
                dataOutput.close();
                return Base64Coder.encodeLines(outputStream.toByteArray());
            } catch (Exception e) {
                throw new IllegalStateException("Unable to save item stacks.", e);
            }
        }

        // Deserializer wasn't taken from ItzGuy. I swear.
        public static Inventory fromBase64(String data) {
            try {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
                BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
                Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());
                for (int i = 0; i < inventory.getSize(); i++)
                    inventory.setItem(i, (ItemStack)dataInput.readObject());
                dataInput.close();
                return inventory;
            } catch (ClassNotFoundException|java.io.IOException e) {
                Bukkit.getLogger().severe("Unable to decode class type. " + e.getClass());
                return null;
            }
        }

        public static Map<String, Object> deserializeBukkitMap(String rawMap) {
            Map<String, Object> map = new HashMap<>();

            Arrays.stream(rawMap.replace("{", "").replace("}", "").split(",")).forEach(s -> {

                String[] split = s.split("=");

                map.put(split[0], split[1]);

            });

            return map;
        }
    }

}
