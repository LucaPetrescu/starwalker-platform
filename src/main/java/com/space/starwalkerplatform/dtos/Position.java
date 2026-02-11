package com.space.starwalkerplatform.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Position {
    @JsonProperty("satlatitude")
    private Double satLatitude;

    @JsonProperty("satlongitude")
    private Double satLongitude;

    @JsonProperty("sataltitude")
    private Double satAltitude;

    @JsonProperty("azimuth")
    private Double azimuth;

    @JsonProperty("elevation")
    private Double elevation;

    @JsonProperty("ra")
    private Double ra;

    @JsonProperty("dec")
    private Double dec;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("eclipsed")
    private Boolean eclipsed;

}
