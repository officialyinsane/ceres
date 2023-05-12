package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CodexEntry_1 extends AbstractEddnEntity { // TODO: Other properties

    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static CodexEntry_1 fromJsonObject(JsonObject obj) throws Exception {
        return CodexEntry_1.builder() // TODO: Other properties
                .bodyName(getAsString(obj, "BodyName", null))
                .latitude(getAsBigDecimal(obj, "Latitude", null))
                .latitude(getAsBigDecimal(obj, "Longitude", null))
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("System").getAsString())
                .build();
    }

}
