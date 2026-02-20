package com.space.starwalkerplatform.dtos.singlesatellite;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class SatellitePosition {

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

    public Instant getInstant() {
        return timestamp != null ? Instant.ofEpochSecond(timestamp) : null;
    }

    public String getTimestampUtc() {
        Instant instant = getInstant();
        return instant != null ? instant.toString() : null;
    }

}
