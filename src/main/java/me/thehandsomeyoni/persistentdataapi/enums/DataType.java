package me.thehandsomeyoni.persistentdataapi.enums;

import org.bukkit.persistence.PersistentDataType;

@Deprecated(since = "0.5.3" , forRemoval = false)
public enum DataType {
    BYTE(PersistentDataType.BYTE),
    SHORT(PersistentDataType.SHORT),
    INTEGER(PersistentDataType.INTEGER),
    LONG(PersistentDataType.LONG),
    FLOAT(PersistentDataType.FLOAT),
    DOUBLE(PersistentDataType.DOUBLE),
    STRING(PersistentDataType.STRING),
    BYTE_ARRAY(PersistentDataType.BYTE_ARRAY),
    INTEGER_ARRAY(PersistentDataType.INTEGER_ARRAY),
    TAG_CONTAINER(PersistentDataType.TAG_CONTAINER),
    LONG_ARRAY(PersistentDataType.LONG_ARRAY)
    ;
    private PersistentDataType type;
    DataType(PersistentDataType type){
        this.type = type;
    }
}
