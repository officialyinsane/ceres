package org.officialyinsane.ceres.ingestor.writer;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.entity.StarPosition;
import org.officialyinsane.ceres.ingestor.writer.repository.StarPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StarPositionWriter {

    @Autowired
    private StarPositionRepository repository;

    public void write(Star star) throws Exception {

        if (star.getStarClass() == null) {
            if (repository.findById(star.getSystemAddress()).isPresent()) {
                return;
            }
        }

        log.info("Saving {}", star);
        repository.save(StarPosition.builder()
                .systemAddress(star.getSystemAddress())
                .name(star.getStarSystem())
                .starClass(star.getStarClass())
                .x(star.getStarPos().getX())
                .y(star.getStarPos().getY())
                .z(star.getStarPos().getZ())
                .build());
    }
}
