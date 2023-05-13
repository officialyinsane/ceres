package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ApproachSettlement_3 extends AbstractEddnEntity { // TODO: Other properties

    private Integer bodyId;
    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long marketId;
    private String marketName;
    private long systemAddress;
    private StarPos position;
    private String systemName;

    public static ApproachSettlement_3 fromJsonObject(JsonObject obj) throws Exception {
        return ApproachSettlement_3.builder()
                .bodyId(getAsInteger(obj, "BodyID", null))
                .bodyName(getAsString(obj, "BodyName", null))
                .latitude(getAsBigDecimal(obj,"Latitude", null))
                .longitude(getAsBigDecimal(obj,"Longitude", null))
                .marketId(getAsLong(obj, "MarketID", null))
                .marketName(getAsString(obj, "Name", null))
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
