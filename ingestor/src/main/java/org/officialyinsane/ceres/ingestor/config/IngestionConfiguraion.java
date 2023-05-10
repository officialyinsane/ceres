package org.officialyinsane.ceres.ingestor.config;

import org.officialyinsane.ceres.ingestor.processor.eddn.EddnMessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EntityScan("org.officialyinsane.ceres")
public class IngestionConfiguraion {

    @Autowired
    private List<EddnMessageProcessor> processorBeans;

    @Bean(name = "eddn-processors")
    public Map<String, EddnMessageProcessor> processors() {
        Map<String, EddnMessageProcessor> returnValue = new ConcurrentHashMap<>(processorBeans.size());
        processorBeans.forEach(processor -> returnValue.put(processor.getMessageName(), processor));

        return returnValue;
    }
}
