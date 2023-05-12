package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FssAllBodiesFound_1 { // TODO: Other properties

    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static FssAllBodiesFound_1 fromJsonObject(JsonObject obj) {
        return FssAllBodiesFound_1.builder() // TODO: Other properties
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("SystemName").getAsString())
                .build();
    }
}
