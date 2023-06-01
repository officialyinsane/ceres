package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.FcMaterialsCapi_1;
import org.officialyinsane.ceres.entity.Market;
import org.officialyinsane.ceres.ingestor.writer.MarketWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FcMaterialsCapiMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private MarketWriter marketWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = FcMaterialsCapi_1.fromJsonObject(event.get("message").getAsJsonObject());

        marketWriter.write(Market.builder()
                .marketId(message.getMarketId())
                .name(message.getCarrierId())
                .build());

        // TODO: write items as commoditites
    }

    @Override
    public String getMessageName() {
        return "fcmaterials_capi_1";
    }
}
