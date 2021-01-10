package edu.devto.java.quarkusreactive.adapter;

import edu.devto.java.quarkusreactive.adapter.pojo.Event;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import static java.lang.String.format;


@ApplicationScoped
public class AnimalConsumer {

    private static final Logger LOG = Logger.getLogger(AnimalConsumer.class);

    @Incoming("animals")
    public void receive(final Event event) {
        LOG.info(format("receive event - %s", event));
    }
}
