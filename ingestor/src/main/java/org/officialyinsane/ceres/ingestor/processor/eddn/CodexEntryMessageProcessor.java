package org.officialyinsane.ceres.ingestor.processor.eddn;

import com.google.gson.JsonParser;
import lombok.val;
import org.officialyinsane.ceres.eddn.CodexEntry_1;
import org.officialyinsane.ceres.eddn.Star;
import org.officialyinsane.ceres.entity.Body;
import org.officialyinsane.ceres.ingestor.writer.BodyWriter;
import org.officialyinsane.ceres.ingestor.writer.StarPositionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodexEntryMessageProcessor extends EddnMessageProcessor {

    @Autowired
    private StarPositionWriter starPositionWriter;

    @Autowired
    private BodyWriter bodyWriter;

    @Override
    public void process(String name, String version, String input) throws Exception {
        val event = JsonParser.parseString(input).getAsJsonObject();
        val message = CodexEntry_1.fromJsonObject(event.get("message").getAsJsonObject());

        starPositionWriter.write(Star.builder()
                .starSystem(message.getSystemName())
                .systemAddress(message.getSystemAddress())
                .starPos(message.getPosition())
                .build());

        if (message.getBodyId() != null && message.getBodyName() != null)
            bodyWriter.write(Body.builder()
                .identity(message.getSystemAddress() + "_" + message.getBodyId())
                .bodyId(message.getBodyId())
                .name(message.getBodyName())
                .systemAddress(message.getSystemAddress())
                .build());

        // TODO: Write the other data
    }

    @Override
    public String getMessageName() {
        return "codexentry_1";
    }
}
