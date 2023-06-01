package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Star extends AbstractEddnEntity {

    private String starClass;
    private StarPos starPos;
    private String starSystem;
    private Long systemAddress;

    public static Star fromJsonObject(JsonObject obj) {
        return Star.builder()
                .starClass(getAsString(obj, "StarClass"))
                .starSystem(getAsString(obj, "StarSystem"))
                .systemAddress(getAsLong(obj, "SystemAddress"))
                .starPos(StarPos.fromJsonArray(getAsJsonArray(obj, "StarPos")))
                .build();
    }
}
