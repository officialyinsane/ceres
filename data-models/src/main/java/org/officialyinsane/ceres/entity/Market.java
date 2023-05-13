package org.officialyinsane.ceres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "markets", catalog = "ceres")
@NoArgsConstructor
public class Market {

    @Id
    @Column(name = "marketId")
    private Long marketId;

    @Column(name = "systemAddress")
    private Long systemAddress;

    @Column(name = "bodyId")
    private Integer bodyId;

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
