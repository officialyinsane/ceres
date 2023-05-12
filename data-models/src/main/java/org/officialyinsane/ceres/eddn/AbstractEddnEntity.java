package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

public abstract class AbstractEddnEntity {

    public static String getAsString(JsonObject obj, String key, String defaultValue) {
        if (obj.has(key))
            return obj.get(key).getAsString();
        return defaultValue;
    }

    public static BigDecimal getAsBigDecimal(JsonObject obj, String key, BigDecimal defaultValue) {
        if (obj.has(key))
            return obj.get(key).getAsBigDecimal();
        return defaultValue;
    }

    public static Long getAsLong(JsonObject obj, String key, Long defaultValue) {
        if (obj.has(key))
            return obj.get(key).getAsLong();
        return defaultValue;
    }
}
