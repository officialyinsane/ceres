package org.officialyinsane.ceres.ingestor.writer;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MarketWriter {

    @Autowired
    private MarketRepository repository;

    public void write(Market market) throws Exception {
        log.info("Saving {}", market);
        repository.save(market);
    }
}
