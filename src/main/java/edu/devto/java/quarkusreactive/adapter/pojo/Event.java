package edu.devto.java.quarkusreactive.adapter.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.kafka.common.header.Headers;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
public class Event {

    private EventBody body;
}
