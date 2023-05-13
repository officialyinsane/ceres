package org.officialyinsane.ceres.ingestor.writer.repository;

import org.officialyinsane.ceres.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
