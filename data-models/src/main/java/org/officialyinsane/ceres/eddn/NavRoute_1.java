package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.val;

@Builder
@Data
public class NavRoute_1 {

    private Route route;

    public static NavRoute_1 fromJsonObject(JsonObject obj) {
        val hops = obj.get("Route").getAsJsonArray();

        return NavRoute_1.builder()
                .route(Route.fromArray(hops))
                .build();
    }
}
