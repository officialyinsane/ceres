package org.officialyinsane.ceres.ingestor.processor.eddn;

public abstract class EddnMessageProcessor {
    public abstract void process(String name, String version, String input) throws Exception;
    public abstract String getMessageName();
}
