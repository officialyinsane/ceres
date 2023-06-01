package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Shipyard_2 extends AbstractEddnEntity {

    private Long marketId;
    private String systemName;
    private String stationName;

    // TODO: Other properties (ships)
    public static Shipyard_2 fromJsonObject(JsonObject obj) throws Exception {
        return Shipyard_2.builder()
                .marketId(getAsLong(obj, "marketId"))
                .systemName(getAsString(obj, "systemName"))
                .stationName(getAsString(obj, "stationName"))
                .build();
    }
}
