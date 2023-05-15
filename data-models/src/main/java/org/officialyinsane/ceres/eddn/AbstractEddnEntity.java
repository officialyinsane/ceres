package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

public abstract class AbstractEddnEntity {

    public static String getAsString(JsonObject obj, String key, String defaultValue) {
        if (obj.has(key))
            return obj.get(key).getAsString();
        return defaultValue;
    }

    public static BigDecimal getAsBigDecimal(JsonObject obj, String key, BigDecimal defaultValue) {
        try {
            if (obj.has(key))
                return obj.get(key).getAsBigDecimal();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return defaultValue;
    }

    public static Long getAsLong(JsonObject obj, String key, Long defaultValue) {
        try {
            if (obj.has(key))
                return obj.get(key).getAsLong();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return defaultValue;
    }

    public static Integer getAsInteger(JsonObject obj, String key, Integer defaultValue) {
        try{
            if (obj.has(key))
                return obj.get(key).getAsInt();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return defaultValue;
    }

    public static JsonArray getAsJsonArray(JsonObject obj, String key, JsonArray defaultValue) {
        if (obj.has(key))
            return obj.get(key).getAsJsonArray();
        return defaultValue;
    }
}
