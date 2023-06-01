package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.Shipyard_2;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.MarketWriter;
import org.officialyinsane.ceres.ingestor.writer.repository.StarPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipyardMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private MarketWriter marketWriter;

    @Autowired
    private StarPositionRepository starRepository;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = Shipyard_2.fromJsonObject(event.get("message").getAsJsonObject());

        val system = starRepository.findByName(message.getSystemName());

        if (message.getMarketId() != null && system.isPresent())
            marketWriter.write(Market.builder()
                .marketId(message.getMarketId())
                .name(message.getStationName())
                .systemAddress(system.get().getSystemAddress())
                .build());
    }

    @Override
    public String getMessageName() {
        return "shipyard_2";
    }
}
