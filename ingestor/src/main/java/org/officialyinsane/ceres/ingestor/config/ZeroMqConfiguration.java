package org.officialyinsane.ceres.ingestor.config;

import lombok.extern.slf4j.Slf4j;
import org.officialyinsane.ceres.ingestor.processor.IngestionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.zeromq.channel.ZeroMqChannel;
import org.springframework.messaging.MessageHandler;
import org.zeromq.ZContext;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
@EnableIntegration
@Slf4j
public class ZeroMqConfiguration {

    @Autowired
    private IngestionProcessor processor;

    @Value("${eddn-upstream:tcp://eddn.edcd.io:9500:9500}")
    private String upstreamUrl;

    @Bean
    public ZContext zContext() {
        return new ZContext();
    }

    @Bean(name = "zeroMqChannel")
    public ZeroMqChannel zeroMqPubSubChannel(ZContext context) {
        ZeroMqChannel channel = new ZeroMqChannel(context, true);
        channel.setConnectUrl(upstreamUrl);
        return channel;
    }

    @Bean
    @ServiceActivator(inputChannel = "zeroMqChannel")
    public MessageHandler subscribe() {

        return message -> {
            byte[] output = new byte[256 * 1024];
            byte[] payload = (byte[]) message.getPayload();
            Inflater inflater = new Inflater();
            inflater.setInput(payload);
          //  ByteArrayOutputStream outputStream = new ByteArrayOutputStream(payload.length);
            try {
                int outputLength = inflater.inflate(output);
                String msg = new String(output, 0, outputLength, UTF_8);

                processor.process(msg);
            } catch (DataFormatException e) {
                log.error("Failed to parse EDDN message", e);
            }
        };
    }
}


