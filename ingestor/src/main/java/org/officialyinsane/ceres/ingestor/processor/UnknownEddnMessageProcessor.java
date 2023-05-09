package org.officialyinsane.ceres.ingestor.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
@Slf4j
public class UnknownEddnMessageProcessor extends EddnMessageProcessor {

    private static final String PATH_PREFIX = "/tmp/ingestor/unknown/";

    @Override
    public void process(String name, String version, String input) {
        File f = new File (PATH_PREFIX + name + "/" + version);

        if (f.exists()) {
            log.info("Refusing due to file exists: {}", input);
            return;
        }
        try {
            f.getParentFile().mkdirs();
            Files.write(f.toPath(), input.getBytes());
            log.info("Successfully written to {} value: {}", name +"/"+ version, input);
        } catch (Exception e) {
            log.error("Failed to write to {}", name + "/" + version, e);
        }
    }

    @Override
    public String getMessageName() {
        return "unknown";
    }
}
