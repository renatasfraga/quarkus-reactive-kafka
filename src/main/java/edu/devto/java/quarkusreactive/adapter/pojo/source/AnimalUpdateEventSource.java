package edu.devto.java.quarkusreactive.adapter.pojo.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
public class AnimalUpdateEventSource implements EventSource {

    private String specie;

    private String breed;

    private String color;
}
