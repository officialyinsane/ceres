package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.FssDicoveryScan_1;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.ingestor.writer.StarPositionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FssDiscoveryScanMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private StarPositionWriter starPositionWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = FssDicoveryScan_1.fromJsonObject(event.get("message").getAsJsonObject());

        starPositionWriter.write(Star.builder()
                .starSystem(message.getSystemName())
                .systemAddress(message.getSystemAddress())
                .starPos(message.getPosition())
                .build());

        // TODO: Write the market, POI (lat/long)
    }

    @Override
    public String getMessageName() {
        return "fssdiscoveryscan_1";
    }
}
