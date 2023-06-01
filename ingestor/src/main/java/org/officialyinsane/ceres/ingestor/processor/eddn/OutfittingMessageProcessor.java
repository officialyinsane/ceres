package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.Outfitting_2;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.MarketWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutfittingMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private MarketWriter marketWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = Outfitting_2.fromJsonObject(event.get("message").getAsJsonObject());

        marketWriter.write(Market.builder()
                .marketId(message.getMarketId())
                .name(message.getStationName())
                .build());
    }

    @Override
    public String getMessageName() {
        return "outfitting_2";
    }
}
