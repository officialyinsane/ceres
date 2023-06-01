package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class FssBodySignals_1 extends AbstractEddnEntity { // TODO: Other properties

    private String systemName;
    private Long systemAddress;
    private StarPos position;

    public static FssBodySignals_1 fromJsonObject(JsonObject obj) throws Exception {
        return FssBodySignals_1.builder() // TODO: Other properties
                .systemAddress(getAsLong(obj, "SystemAddress"))
                .position(StarPos.fromJsonArray(getAsJsonArray(obj, "StarPos")))
                .systemName(getAsString(obj, "StarSystem"))
                .build();
    }
}
