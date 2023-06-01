package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.Journal_1;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.entity.Market;
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
    private StarPositionRepository starRepository;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = Journal_1.fromJsonObject(event.get("message").getAsJsonObject());

        starWriter.write(Star.builder()
                .systemAddress(message.getSystemAddress())
                .starSystem(message.getSystemName())
                .starPos(message.getStarPos())
                .build());

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
        return "journal_1";
    }
}
