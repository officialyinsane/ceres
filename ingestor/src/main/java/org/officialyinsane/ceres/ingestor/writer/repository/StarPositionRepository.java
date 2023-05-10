package org.officialyinsane.ceres.ingestor.writer.repository;

import org.officialyinsane.ceres.entity.StarPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarPositionRepository extends JpaRepository<StarPosition, Long> {
}
