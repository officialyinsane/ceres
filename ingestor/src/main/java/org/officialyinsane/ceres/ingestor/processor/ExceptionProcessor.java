package org.officialyinsane.ceres.ingestor.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

@Service
@Slf4j
public class ExceptionProcessor {

    private static final String PATH_PREFIX = "/tmp/ingestor/problems/";
    private static final String SUFFIX = ".exception";

    public void process(String input, Exception e) {
        log.warn("Processing exception for {}", input, e);
        File f = new File(PATH_PREFIX + getCheckSumFor(e) + SUFFIX);

        if (f.exists()) {
            log.info("Refusing due to file exists: {}", input);
            return;
        }
        try {
            f.getParentFile().mkdirs();
            Files.write(f.toPath(), getErrorMessage(input, e).getBytes());
            log.info("Successfully written to {}", f.getAbsolutePath());
        } catch (Exception ex) {
            log.error("Failed to write exception to {}", f.getAbsolutePath(), ex);
        }
    }

    private String getErrorMessage(String input, Exception e) {
        StringBuffer buf = new StringBuffer("{\"message\":" + input);
        buf.append(",\"error\":{")
                .append("\"message\":\"")
                .append(e.getLocalizedMessage())
                .append("\"");
        stream(e.getStackTrace())
                .map(el -> "\"class\":\"" + el.getClassName() + "\",\"line\":\"" + el.getLineNumber() + "\"")
                .forEach(buf::append);
        buf.append("}");

        return buf.toString();
    }

    protected static String getCheckSumFor(Exception e) {
        String buf = e.getLocalizedMessage() + "," +
                stream(e.getStackTrace())
                    .map(el -> el.getClassName() + ":" + el.getLineNumber())
                    .collect(joining(","));

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(buf.getBytes());

            StringBuffer output = new StringBuffer();
            for (byte b : digest.digest())
                output.append(String.format("%02x", b));

            return output.toString();
        } catch (NoSuchAlgorithmException nsae) {
            log.error("Unable to get digest", e);
        }
        return "wtf";
    }
}
