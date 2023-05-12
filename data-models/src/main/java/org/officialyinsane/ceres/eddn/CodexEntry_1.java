package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CodexEntry_1 { // TODO: Other properties

    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static CodexEntry_1 fromJsonObject(JsonObject obj) {
        return CodexEntry_1.builder() // TODO: Other properties
                .bodyName(obj.get("BodyName").getAsString())
                .latitude(obj.get("Latitude").getAsBigDecimal())
                .latitude(obj.get("Logitude").getAsBigDecimal())
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("System").getAsString())
                .build();
    }
}
