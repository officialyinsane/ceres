package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Commodity_3 extends AbstractEddnEntity { // TODO: Other properties

    private List<Commodity_1> commodity1List;
    private List<Economy_1> economy1List;
    private Long marketId;
    private String stationName;
    private String systemName;
    private List<String> prohibitions;

    public static Commodity_3 fromJsonObject(JsonObject obj) throws Exception {
        return Commodity_3.builder()
                .marketId(getAsLong(obj, "marketId"))
                .commodity1List(getAsJsonArray(obj, "commodities")
                        .asList()
                        .stream()
                        .map(Commodity_1::fromJsonElement)
                        .collect(toList()))
                .economy1List(getAsJsonArray(obj, "economies")
                        .asList()
                        .stream()
                        .map(Economy_1::fromJsonElement)
                        .collect(toList()))
                .stationName(getAsString(obj, "stationName"))
                .systemName(getAsString(obj, "systemName"))
                .prohibitions(getAsJsonArray(obj, "prohibited")
                        .asList().stream()
                        .map(JsonElement::getAsString)
                        .collect(toList()))
                .build();
    }
}
