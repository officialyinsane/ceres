package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.val;

import java.math.BigDecimal;

@Builder
@Data
public class ApproachSettlement_3 extends AbstractEddnEntity { // TODO: Other properties

    private String bodyName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long marketId;
    private long systemAddress;
    private StarPos position;
    private String systemName;

    public static ApproachSettlement_3 fromJsonObject(JsonObject obj) throws Exception {
        return ApproachSettlement_3.builder()
                .bodyName(obj.get("BodyName").getAsString())
                .latitude(obj.get("Latitude").getAsBigDecimal())
                .latitude(obj.get("Longitude").getAsBigDecimal())
                .marketId(getAsLong(obj, "MarketID", null))
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
