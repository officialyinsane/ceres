package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ApproachSettlement_1 extends AbstractEddnEntity { // TODO: Other properties

    private Integer bodyId;
    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long marketId;
    private String marketName;
    private StarPos position;
    private long systemAddress;
    private String systemName;

    public static ApproachSettlement_1 fromJsonObject(JsonObject obj) throws Exception {
        return ApproachSettlement_1.builder()
                .bodyId(getAsInteger(obj, "BodyID"))
                .bodyName(getAsString(obj, "BodyName")) // TODO: Write bodies
                .latitude(getAsBigDecimal(obj,"Latitude"))
                .longitude(getAsBigDecimal(obj,"Longitude"))
                .marketId(getAsLong(obj, "MarketID"))
                .marketName(getAsString(obj, "Name"))
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
