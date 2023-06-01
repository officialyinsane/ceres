package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Outfitting_2 extends AbstractEddnEntity {

    private Long marketId;
    private String systemName;
    private String stationName;

    // TODO: Other properties (modules)
    public static Outfitting_2 fromJsonObject(JsonObject obj) throws Exception {
        return Outfitting_2.builder()
                .marketId(getAsLong(obj, "marketId"))
                .systemName(getAsString(obj, "systemName"))
                .stationName(getAsString(obj, "stationName"))
                .build();
    }
}
