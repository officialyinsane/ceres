package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class NavBeaconScan_1 extends AbstractEddnEntity { // TODO: Other properties

    private String systemName;
    private long systemAddress;
    private StarPos position;

    public static NavBeaconScan_1 fromJsonObject(JsonObject obj) throws Exception {
        return NavBeaconScan_1.builder() // TODO: Other properties
                .systemAddress(obj.get("SystemAddress").getAsLong())
                .position(StarPos.fromJsonArray(obj.get("StarPos").getAsJsonArray()))
                .systemName(obj.get("StarSystem").getAsString())
                .build();
    }
}
