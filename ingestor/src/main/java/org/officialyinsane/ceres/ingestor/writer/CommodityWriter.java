package org.officialyinsane.ceres.ingestor.writer;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.entity.Commodity;
import org.officialyinsane.ceres.ingestor.writer.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommodityWriter {

    @Autowired
    private CommodityRepository repository;

    public void writeAll(List<Commodity> commodityList) throws Exception {
        if (commodityList.isEmpty())
            return;
        log.info("Saving {}", commodityList);
        repository.saveAll(commodityList);
    }
}
