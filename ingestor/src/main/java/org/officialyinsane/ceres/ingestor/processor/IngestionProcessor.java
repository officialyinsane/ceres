package org.officialyinsane.ceres.ingestor.processor;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.ingestor.processor.eddn.EddnMessageDifferenceProcessor;
import org.officialyinsane.ceres.ingestor.processor.eddn.EddnMessageProcessor;
import org.officialyinsane.ceres.ingestor.processor.eddn.UnknownEddnMessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngestionProcessor {

    @Autowired
    private List<EddnMessageProcessor> processors;

    @Autowired
    private EddnMessageDifferenceProcessor differenceProcessor;

    @Autowired
    private ExceptionProcessor exceptionProcessor;

    private static final String INGESTION_PREFIX = "{\"$schemaRef\": \"";

    public void process(String input) {
        String url = input.substring(INGESTION_PREFIX.length(), input.indexOf("\"", INGESTION_PREFIX.length() + 1));
        String[] parts = url.split("/");

        process(parts[4], parts[5], input);
    }

    private void process(String name, String version, String input) {
        EddnMessageProcessor processor = getProcessorFor(name, version);
        try {
            differenceProcessor.process(name, version, input);
            processor.process(name, version, input);
        } catch (Exception e) {
            exceptionProcessor.process(input, e);
        }
    }

    private EddnMessageProcessor getProcessorFor(String name, String version) {
        return processors.stream()
                .filter(p -> p.getMessageName().equals(name+"_"+version))
                .findFirst().orElse(new UnknownEddnMessageProcessor());
    }
}
