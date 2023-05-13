package org.officialyinsane.ceres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.officialyinsane.ceres.eddn.Commodity_1;

@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "commodities", catalog = "ceres")
@NoArgsConstructor
public class Commodity {

    @Id
    @Column(name = "marketCommodity")
    private String marketCommodity;

    @Column(name = "marketId")
    private Long marketId;

    @Column(name = "systemAddress")
    private Long systemAddress;

    @Column(name = "isProhibited")
    private Boolean isProhibited;

    @Column(name = "buyPrice")
    private Integer buyPrice;

    private Integer demand;

    @Column(name = "demandBracket")
    private Integer demandBracket;

    @Column(name = "meanPrice")
    private Integer meanPrice;
    private String name;

    @Column(name = "sellPrice")
    private Integer sellPrice;
    private Integer stock;

    @Column(name = "stockBracket")
    private Integer stockBracket;

    public static Commodity from(Commodity_1 c, Long marketId, String systemName, boolean isProhibited) {
        return Commodity.builder() // TODO: Look up the system address ?
                .marketCommodity(marketId + "_" + c.getName())
                .marketId(marketId)
                .isProhibited(isProhibited)
                .buyPrice(c.getBuyPrice())
                .demand(c.getDemand())
                .demandBracket(c.getDemandBracket())
                .meanPrice(c.getMeanPrice())
                .name(c.getName())
                .sellPrice(c.getSellPrice())
                .stock(c.getStock())
                .stockBracket(c.getStockBracket())
                .build();
    }
}
