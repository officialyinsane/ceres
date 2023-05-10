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
@Table(name = "systems", catalog = "ceres")
@NoArgsConstructor
public class StarPosition {

    @Id
    @Column(name = "systemAddress")
    private Long systemAddress;

    private String name;

    @Column(name = "starClass", length = 1)
    private String starClass;

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal z;

}
