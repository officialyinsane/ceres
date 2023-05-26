package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
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
                .bodyName(getAsString(obj, "BodyName"))
                .latitude(getAsBigDecimal(obj, "Latitude"))
                .latitude(getAsBigDecimal(obj, "Longitude"))
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("System").getAsString())
                .build();
    }

}
