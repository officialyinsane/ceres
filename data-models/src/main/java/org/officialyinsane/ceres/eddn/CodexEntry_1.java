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

    private Integer bodyId;
    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String systemName;
    private Long systemAddress;
    private StarPos position;

    public static CodexEntry_1 fromJsonObject(JsonObject obj) throws Exception {
        return CodexEntry_1.builder() // TODO: Other properties
                .bodyId(getAsInteger(obj, "BodyID"))
                .bodyName(getAsString(obj, "BodyName"))
                .latitude(getAsBigDecimal(obj, "Latitude"))
                .latitude(getAsBigDecimal(obj, "Longitude"))
                .systemAddress(getAsLong(obj,"SystemAddress"))
                .position(StarPos.fromJsonArray(getAsJsonArray(obj, "StarPos")))
                .systemName(getAsString(obj, "System"))
                .build();
    }

}
