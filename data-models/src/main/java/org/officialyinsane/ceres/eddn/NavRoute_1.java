package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class NavRoute_1 extends AbstractEddnEntity {

    private Route route;

    public static NavRoute_1 fromJsonObject(JsonObject obj) throws Exception {
        return NavRoute_1.builder()
                .route(Route.fromArray(getAsJsonArray(obj, "Route")))
                .build();
    }
}
