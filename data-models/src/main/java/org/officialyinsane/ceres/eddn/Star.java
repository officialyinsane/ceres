package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Star {

    private String starClass;
    private StarPos starPos;
    private String starSystem;
    private long systemAddress;

    public static Star fromJsonObject(JsonObject star) {
        return Star.builder()
                .starClass(star.get("StarClass").getAsString())
                .starSystem(star.get("StarSystem").getAsString())
                .systemAddress(star.get("SystemAddress").getAsLong())
                .starPos(StarPos.fromJsonArray(star.get("StarPos").getAsJsonArray()))
                .build();
    }
}
