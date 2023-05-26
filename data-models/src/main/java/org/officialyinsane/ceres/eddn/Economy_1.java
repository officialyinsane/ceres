package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Economy_1 extends AbstractEddnEntity {

    private String name;
    private Integer proportion;

    public static Economy_1 fromJsonElement(JsonElement e) {
        JsonObject obj = e.getAsJsonObject();
        return Economy_1.builder()
                .name(getAsString(obj, "name"))
                .proportion(getAsInteger(obj, "proportion"))
                .build();
    }
}
