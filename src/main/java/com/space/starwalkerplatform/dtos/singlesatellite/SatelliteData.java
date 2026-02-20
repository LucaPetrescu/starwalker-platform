package com.space.starwalkerplatform.dtos.singlesatellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SatelliteData {

    @JsonProperty("info")
    private SatelliteInfo info;

    @JsonProperty("positions")
    private List<SatellitePosition> positions;

}
