package me.thehandsomeyoni.persistentdataapi.manager;

import java.io.*;

/**
 * @author TheHandsomeYoni
 * @since 1.6.0
 * Disclaimer:
 * This class serializes the data into bytes, used only by the api itself.
 * This class might become deprecated in the future.
 */
public class DataSerializer {
    private static ByteArrayOutputStream byteArrayOutput;
    private static ObjectOutputStream objectOutput;

    private static ByteArrayInputStream byteArrayInput;
    private static ObjectInputStream objectInput;


    /**
     * Turns the raw data into byte array.
     * @param object The data.
     * @return The data in bytes.
     */
    public static byte[] serialize(Object object) {
        try{
            byteArrayOutput = new ByteArrayOutputStream();
            objectOutput = new ObjectOutputStream(byteArrayOutput);
            objectOutput.writeObject(object);
            objectOutput.flush();
            return byteArrayOutput.toByteArray();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Turns the byte array into data.
     * @param bytes The bytes.
     * @return The data.
     */
    public static Serializable deserialize(byte[] bytes) {
        byteArrayInput = new ByteArrayInputStream(bytes);
        try{
            objectInput = new ObjectInputStream(byteArrayInput);
            return (Serializable) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
