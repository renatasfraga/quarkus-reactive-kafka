package edu.devto.java.quarkusreactive.adapter.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.devto.java.quarkusreactive.adapter.pojo.enumerator.EventType;
import edu.devto.java.quarkusreactive.adapter.pojo.source.AnimalCreateEventSource;
import edu.devto.java.quarkusreactive.adapter.pojo.source.AnimalUpdateEventSource;
import edu.devto.java.quarkusreactive.adapter.pojo.source.EventSource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.*;

@ToString
@Getter
@Setter
public class EventBody {

    private EventType eventType;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "eventType"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = AnimalCreateEventSource.class, name = "ANIMAL_CREATE_EVENT"),

            @JsonSubTypes.Type(value = AnimalUpdateEventSource.class, name = "ANIMAL_UPDATE_EVENT")}
    )
    private EventSource source;
}
