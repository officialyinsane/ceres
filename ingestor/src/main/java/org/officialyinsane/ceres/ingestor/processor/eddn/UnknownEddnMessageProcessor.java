package org.officialyinsane.ceres.ingestor.processor.eddn;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.ingestor.processor.eddn.EddnMessageProcessor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
@Slf4j
public class UnknownEddnMessageProcessor extends EddnMessageProcessor {

    private static final String PATH_PREFIX = "/tmp/ingestor/unknown/";
    private static final String PATH_SUFFIX = ".json";

    @Override
    public void process(String name, String version, String input) {
        File f = new File (PATH_PREFIX + name + "/" + version + PATH_SUFFIX);

        if (f.exists()) {
            log.info("Refusing due to file exists: {} {}", f.getAbsolutePath(), input);
            return;
        }
        try {
            f.getParentFile().mkdirs();
            Files.write(f.toPath(), input.getBytes());
            log.info("Successfully written to {} value: {}", f.getAbsolutePath(), input);
        } catch (Exception e) {
            log.error("Failed to write to {}", f.getAbsolutePath(), e);
        }
    }

    @Override
    public String getMessageName() {
        return "unknown";
    }
}
