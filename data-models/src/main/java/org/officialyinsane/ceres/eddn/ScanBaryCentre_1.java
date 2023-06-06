package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ScanBaryCentre_1 extends AbstractEddnEntity { // TODO: Other properties

    private Integer bodyId;
    private String bodyName;
    private String systemName;
    private Long systemAddress;
    private StarPos position;

    public static ScanBaryCentre_1 fromJsonObject(JsonObject obj) throws Exception {
        return ScanBaryCentre_1.builder() // TODO: Other properties
                .bodyId(getAsInteger(obj, "BodyID"))
                .bodyName(getAsString(obj, "BodyName"))
                .systemAddress(getAsLong(obj, "SystemAddress"))
                .position(StarPos.fromJsonArray(getAsJsonArray(obj, "StarPos")))
                .systemName(getAsString(obj, "StarSystem"))
                .build();
    }
}
