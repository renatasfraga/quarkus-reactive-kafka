package edu.devto.java.quarkusreactive.adapter.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.devto.java.quarkusreactive.adapter.pojo.Event;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.jboss.logging.Logger;

import static java.lang.String.format;

public class EventDeserializer implements Deserializer<Event> {

    private static final Logger LOG = Logger.getLogger(EventDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Event deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public Event deserialize(String topic, Headers headers, byte[] data) {
        LOG.info(format("Deserialize event: topic - %s | headers - %s", topic, headers.toString()));

        try {
            return objectMapper.readValue(data, Event.class);
        } catch (Exception ex) {
            LOG.error(format("Deserialize event error: cause - %s", ex.getMessage()));

            return new Event();
        }
    }
}
