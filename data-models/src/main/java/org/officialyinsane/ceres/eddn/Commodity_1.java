package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Commodity_1 extends AbstractEddnEntity {

    private Integer buyPrice;
    private Integer demand;
    private Integer demandBracket;
    private Integer meanPrice;
    private String name;
    private Integer sellPrice;
    private Integer stock;
    private Integer stockBracket;

    public static Commodity_1 fromJsonElement(JsonElement e) {
        JsonObject obj = e.getAsJsonObject();
        return Commodity_1.builder()
                .buyPrice(getAsInteger(obj, "buyPrice"))
                .demand(getAsInteger(obj, "demand"))
                .demandBracket(getAsInteger(obj, "demandBracket"))
                .meanPrice(getAsInteger(obj, "meanPrice"))
                .name(getAsString(obj, "name"))
                .sellPrice(getAsInteger(obj, "sellPrice"))
                .stock(getAsInteger(obj, "stock"))
                .stockBracket(getAsInteger(obj, "stockBracket"))
                .build();
    }
}
