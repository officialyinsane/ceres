package org.officialyinsane.ceres.api.entity;

import jakarta.persistence.*;
import lombok.Data;


import static jakarta.persistence.EnumType.STRING;

@Data
@Entity
@Table(schema = "api", name = "users")
public class User {

    @Id
    private Long id;

    @Column
    private String username;

    @Enumerated(STRING)
    private Provider provider;

}
