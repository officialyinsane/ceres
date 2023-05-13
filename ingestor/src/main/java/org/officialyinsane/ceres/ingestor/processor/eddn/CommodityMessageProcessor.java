package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.Commodity_3;
import org.officialyinsane.ceres.entity.Commodity;
import org.officialyinsane.ceres.ingestor.writer.CommodityWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CommodityMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private CommodityWriter commodityWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = Commodity_3.fromJsonObject(event.get("message").getAsJsonObject());

        commodityWriter.writeAll(message.getCommodity1List().stream()
                .map(c -> Commodity.from(c, message.getMarketId(), message.getSystemName(), message.getProhibitions().contains(c.getName())))
                .collect(Collectors.toList()));

        // TODO: Write prohibitions to another table
    }

    @Override
    public String getMessageName() {
        return "commodity_3";
    }
}
