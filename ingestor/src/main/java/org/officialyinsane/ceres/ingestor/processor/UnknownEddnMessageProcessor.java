package org.officialyinsane.ceres.ingestor.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
@Slf4j
public class UnknownEddnMessageProcessor extends EddnMessageProcessor {

    private static final String PATH_PREFIX = "/tmp/ingestor/unknown/";

    @Override
    public void process(String name, String version, String input) {
        String dir = PATH_PREFIX + name + "/";
        Path path = Paths.get(dir + "/" + version);
        if (Files.exists(path)) {
            log.info("Refusing due to file exists: {}", input);
            return;
        }
        try {
            Files.createDirectories(Paths.get(dir));
            Files.createFile(path);
            Files.write(path, input.getBytes());
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
