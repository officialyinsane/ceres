package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.ApproachSettlement_3;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.MarketWriter;
import org.officialyinsane.ceres.ingestor.writer.StarPositionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproachSettlementMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private StarPositionWriter starPositionWriter;

    @Autowired
    private MarketWriter marketWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = ApproachSettlement_3.fromJsonObject(event.get("message").getAsJsonObject());

        starPositionWriter.write(Star.builder()
                .starSystem(message.getSystemName())
                .systemAddress(message.getSystemAddress())
                .starPos(message.getPosition())
                .build());

        if (message.getMarketId() != null) {
            marketWriter.write(Market.builder()
                    .marketId(message.getMarketId())
                    .systemAddress(message.getSystemAddress())
                    .bodyId(message.getBodyId())
                    .latitude(message.getLatitude())
                    .longitude(message.getLongitude())
                    .name(message.getMarketName())
                    .build());
        }
        // TODO: Write the POI (lat/long)
    }

    @Override
    public String getMessageName() {
        return "approachsettlement_1";
    }
}
