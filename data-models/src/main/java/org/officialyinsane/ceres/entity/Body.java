package org.officialyinsane.ceres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "bodies", catalog = "ceres")
@NoArgsConstructor
public class Body {

    @Id
    @Column(name = "bodyIdentity")
    private String identity;

    @Column(name = "bodyId")
    private Integer bodyId;

    @Column(name = "name")
    private String name;

    @Column(name = "systemAddress")
    private Long systemAddress;
}
