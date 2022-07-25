package me.thehandsomeyoni.persistentdataapi.customdata;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serializable;

/**
 * Using this class you can create your own custom data types.
 * DISCLAIMER:
 * Custom data types MUST be serializable.
 * @author TheHandsomeYoni
 * @since 1.5.0
 */
public class CustomDataType implements PersistentDataType<byte[], Serializable> {
    private Serializable dataClass;

    /**
     * Initializes the CustomDataType.
     * @param dataClass The class of the data, Must be serializable.
     */
    public CustomDataType(Serializable dataClass) {
        this.dataClass = dataClass;
    }

    /**
     * Gets the class of the data in bytes.
     * @return The class of the data in bytes.
     */
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    /**
     * Gets the class of the data.
     * @return The class of the data.
     */
    @Override
    public Class<Serializable> getComplexType() {
        return Serializable.class;
    }

    /**
     * Turns the data into bytes.
     * @param complex The data.
     * @param context The context of the data.
     * @return The data in bytes.
     */
    @Override
    public byte[] toPrimitive(Serializable complex, PersistentDataAdapterContext context) {
        return DataSerializer.serialize(complex);
    }

    /**
     * Turns the bytes into data.
     * @param primitive The bytes.
     * @param context The context of the data.
     * @return The data.
     */
    @Override
    public Serializable fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
        return (Serializable) DataSerializer.deserialize(primitive);
    }
}
