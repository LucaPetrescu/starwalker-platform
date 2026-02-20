package com.space.starwalkerplatform.dtos.abovesatellites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SatellitesAboveData {

    @JsonProperty("info")
    private SatellitesAboveInfo satellitesAboveInfo;

    @JsonProperty("above")
    private List<SatellitesAbovePosition> satellitesAbovePosition;

}
