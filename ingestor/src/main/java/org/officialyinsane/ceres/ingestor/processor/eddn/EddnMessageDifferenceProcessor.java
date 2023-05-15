package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class EddnMessageDifferenceProcessor extends EddnMessageProcessor {

    private static final String PATH_PREFIX = "/tmp/ingestor/unknown/";
    private static final String PATH_SUFFIX = ".json";

    @Override
    public void process(String name, String version, String input) {

        JsonObject obj = JsonParser.parseString(input).getAsJsonObject();
        String checksum = getCheckSumFor(appendKeys(obj));
        File f = new File (PATH_PREFIX + name + "/" + version + "_dir/" + checksum + PATH_SUFFIX);

        if (f.exists()) {
            // log.info("Refusing due to file exists: {}, {}", f.getAbsolutePath(), input); // TODO: Make this configurable
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

    private String appendKeys(JsonObject obj) {
        StringBuffer buf = new StringBuffer();
        obj.keySet().forEach( key -> {
            buf.append(key);
            JsonElement element = obj.get(key);
            if (element.isJsonObject() && !element.isJsonPrimitive() && !element.isJsonArray())
                buf.append(appendKeys(element.getAsJsonObject()));
        });
        return buf.toString();
    }

    private static String getCheckSumFor(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(str.getBytes());

            StringBuilder output = new StringBuilder();
            for (byte b : digest.digest())
                output.append(String.format("%02x", b));

            return output.toString();
        } catch (NoSuchAlgorithmException nsae) {
            log.error("Unable to get digest", nsae);
        }
        return "wtf";
    }

    @Override
    public String getMessageName() {
        return "difference";
    }
}
