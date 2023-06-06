package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.Journal_1;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.entity.Body;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.BodyWriter;
import org.officialyinsane.ceres.ingestor.writer.MarketWriter;
import org.officialyinsane.ceres.ingestor.writer.StarPositionWriter;
import org.officialyinsane.ceres.ingestor.writer.repository.StarPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private MarketWriter marketWriter;

    @Autowired
    private StarPositionWriter starWriter;

    @Autowired
    private BodyWriter bodyWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = Journal_1.fromJsonObject(event.get("message").getAsJsonObject());

        starWriter.write(Star.builder()
                .systemAddress(message.getSystemAddress())
                .starSystem(message.getSystemName())
                .starPos(message.getStarPos())
                .build());

        if (message.getBodyId() != null)
            bodyWriter.write(Body.builder()
                .identity(message.getSystemAddress() + "_" + message.getBodyId())
                .bodyId(message.getBodyId())
                .name(message.getBodyName())
                .systemAddress(message.getSystemAddress())
                .build());

        if (message.getMarketId() != null && message.getSystemAddress() != null)
            marketWriter.write(Market.builder()
                .marketId(message.getMarketId())
                .name(message.getStationName())
                .systemAddress(message.getSystemAddress())
                .build());
    }

    @Override
    public String getMessageName() {
        return "journal_1";
    }
}
