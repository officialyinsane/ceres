package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FssBodySignals_1 { // TODO: Other properties

    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static FssBodySignals_1 fromJsonObject(JsonObject obj) {
        return FssBodySignals_1.builder() // TODO: Other properties
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
