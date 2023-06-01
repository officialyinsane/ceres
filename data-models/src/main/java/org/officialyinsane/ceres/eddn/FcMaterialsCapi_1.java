package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class FcMaterialsCapi_1 extends AbstractEddnEntity {

    private String carrierId;
    private Long marketId;

    public static FcMaterialsCapi_1 fromJsonObject(JsonObject obj) throws Exception {
        return FcMaterialsCapi_1.builder()
                .carrierId(getAsString(obj, "CarrierId"))
                .marketId(getAsLong(obj, "MarketID"))
                // TODO: Purchases and sales
                .build();
    }
}
