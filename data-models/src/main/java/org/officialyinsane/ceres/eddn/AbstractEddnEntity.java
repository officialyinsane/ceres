package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

public abstract class AbstractEddnEntity {

    public static String getAsString(JsonObject obj, String key) {
        if (obj.has(key))
            return obj.get(key).getAsString();
        return null;
    }

    public static BigDecimal getAsBigDecimal(JsonObject obj, String key) {
        try {
            if (obj.has(key))
                return obj.get(key).getAsBigDecimal();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return null;
    }

    public static Long getAsLong(JsonObject obj, String key) {
        try {
            if (obj.has(key))
                return obj.get(key).getAsLong();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return null;
    }

    public static Integer getAsInteger(JsonObject obj, String key) {
        try{
            if (obj.has(key))
                return obj.get(key).getAsInt();
        } catch (NumberFormatException nfe) {
            // nop
        }
        return null;
    }

    public static JsonArray getAsJsonArray(JsonObject obj, String key) {
        if (obj.has(key))
            return obj.get(key).getAsJsonArray();
        return new JsonArray();
    }
}
