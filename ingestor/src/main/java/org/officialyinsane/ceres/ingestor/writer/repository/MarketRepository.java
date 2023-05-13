package org.officialyinsane.ceres.ingestor.writer.repository;

import org.officialyinsane.ceres.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
