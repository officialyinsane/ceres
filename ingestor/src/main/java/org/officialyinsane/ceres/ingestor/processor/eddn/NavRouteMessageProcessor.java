package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.NavRoute_1;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.ingestor.writer.StarPositionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavRouteMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private StarPositionWriter starPositionWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = NavRoute_1.fromJsonObject(event.get("message").getAsJsonObject());

        for (Star star : message.getRoute().getStars()) {
            starPositionWriter.write(star);
        }
    }

    @Override
    public String getMessageName() {
        return "navroute_1";
    }
}
