package org.officialyinsane.ceres.eddn;

import com.google.gson.JsonArray;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class StarPos {

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal z;

    public static StarPos fromJsonArray(JsonArray position) {
        return StarPos.builder()
                .x(position.get(0).getAsBigDecimal())
                .y(position.get(1).getAsBigDecimal())
                .z(position.get(2).getAsBigDecimal())
                .build();
    }
}
