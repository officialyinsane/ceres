package org.officialyinsane.ceres.ingestor.writer;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.entity.Body;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.repository.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BodyWriter {

    @Autowired
    private BodyRepository repository;

    public void write(Body body) throws Exception {
        log.info("Saving {}", body);
        repository.save(body);
    }
}
