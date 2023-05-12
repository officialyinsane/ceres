package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Builder
@Data
public class Route extends AbstractEddnEntity{

    private List<Star> stars;

    public static Route fromArray(JsonArray hops) throws Exception {
        return Route.builder()
                .stars(hops.asList().stream()
                        .map(JsonElement::getAsJsonObject)
                        .map(Star::fromJsonObject)
                        .collect(toList()))
                .build();
    }
}
