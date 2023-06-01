package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class FcMaterialsJournal_1 extends AbstractEddnEntity {

    private String carrierId;
    private String carrierName;
    private Long marketId;

    public static FcMaterialsJournal_1 fromJsonObject(JsonObject obj) throws Exception {
        return FcMaterialsJournal_1.builder()
                .carrierId(getAsString(obj, "CarrierId"))
                .carrierName(getAsString(obj, "CarrierName"))
                .marketId(getAsLong(obj, "MarketID"))
                .build();
    }
}
