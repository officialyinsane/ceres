package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FssSignalDiscovered_1 extends AbstractEddnEntity { // TODO: Other properties

    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static FssSignalDiscovered_1 fromJsonObject(JsonObject obj) throws Exception {
        return FssSignalDiscovered_1.builder() // TODO: Other properties
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
