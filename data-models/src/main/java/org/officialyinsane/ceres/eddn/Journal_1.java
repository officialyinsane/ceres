package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Journal_1 extends AbstractEddnEntity {

    private Integer bodyId;
    private String bodyName;
    private Long marketId;
    private StarPos starPos;
    private String systemName;
    private Long systemAddress;
    private String stationName;

    // TODO: Other properties (bodies, conflicts, economies, faction, government, station services, station type, allegiance, security, distance from star)
    public static Journal_1 fromJsonObject(JsonObject obj) throws Exception {
        return Journal_1.builder()
                .marketId(getAsLong(obj, "MarketID"))
                .starPos(StarPos.fromJsonArray(getAsJsonArray(obj, "StarPos")))
                .systemAddress(getAsLong(obj, "SystemAddress"))
                .systemName(getAsString(obj, "StarSystem"))
                .stationName(getAsString(obj, "StationName"))
                .build();
    }
}
